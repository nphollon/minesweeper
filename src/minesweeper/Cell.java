package minesweeper;

public class Cell {
    private final boolean armed;
    private State state;

    public Cell(final boolean armed) {
        this.armed = armed;
        this.state = State.MYSTERIOUS;
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

    @Override
    public String toString() {
        return state.symbol;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Cell cell = (Cell) o;

        return armed == cell.armed && state == cell.state;
    }

    @Override
    public int hashCode() {
        return (31 * (armed ? 1 : 0)) + state.hashCode();
    }

    public static enum State {
        MYSTERIOUS("x"), DETONATED("m"), CLEAR("0"), FLAGGED("f");

        private String symbol;

        private State(String symbol) {
            this.symbol = symbol;
        }
    }
}
