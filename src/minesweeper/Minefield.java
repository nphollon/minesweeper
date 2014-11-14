package minesweeper;

import java.util.List;

public class Minefield {
    private List<List<Cell>> cells;
    private State state;

    public Minefield(final List<List<Cell>> cells) {
        this.cells = cells;
        this.state = State.MYSTERIOUS;
    }

    public State getState() {
        return state;
    }

    public void flag(final int x, final int y) {
        getCell(x, y).flag();

        updateState();
    }

    public void open(final int x, final int y) {
        getCell(x, y).open();

        updateState();
    }

    public String getMessage() {
        return state.message;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public String toString() {
        String display = "";

        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                display += cell.toString();
            }
            display += "\n";
        }

        return display;
    }

    private Cell getCell(final int x, final int y) {
        return cells.get(y).get(x);
    }

    private void updateState() {
        if (anyDetonations()) {
            state = State.DETONATED;
        } else if (anyMysteries()) {
            state = State.MYSTERIOUS;
        } else {
            state = State.CLEAR;
        }
    }

    private boolean anyMysteries() {
        return cells.stream().anyMatch(row -> row.stream().anyMatch(Cell::isUnsolved));
    }

    private boolean anyDetonations() {
        return cells.stream().anyMatch(row -> row.stream().anyMatch(Cell::isDetonated));
    }

    public static enum State {
        MYSTERIOUS(""),
        CLEAR("Wow, you cleared the minefield! Game over!"),
        DETONATED("Oops, you stepped on a mine! Game over!");

        private final String message;

        private State(String message) {
            this.message = message;
        }
    }
}
