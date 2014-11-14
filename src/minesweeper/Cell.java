package minesweeper;

public class Cell {
    private final boolean armed;
    private State state;

    public Cell(final boolean armed) {
        this.armed = armed;
        this.state = State.MYSTERIOUS;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Cell)) {
            return false;
        }
        Cell otherCell = (Cell) obj;
        return (armed == otherCell.armed) && (state == otherCell.state);
    }

    public void open() {
        state = armed ? State.DETONATED : State.CLEAR;
    }

    public void flag() {
        state = State.FLAGGED;
    }

    public boolean isDetonated() {
        return state == State.DETONATED;
    }

    public boolean isUnsolved() {
        return state == State.MYSTERIOUS || (state == State.FLAGGED && !armed);
    }

    public String toString() {
        return state.symbol;
    }

    public static enum State {
        MYSTERIOUS("x"), DETONATED("m"), CLEAR("0"), FLAGGED("f");

        private String symbol;

        private State(String symbol) {
            this.symbol = symbol;
        }
    }
}
