package minesweeper;

import java.util.ArrayList;
import java.util.List;

public class MinefieldFactory {

    private static final char ROW_SEPARATOR = ',';
    private static final char MINE_SYMBOL = 'm';

    public static Minefield build(final String mines) {
        List<List<Cell>> cells = new ArrayList<>();
        List<Cell> rowUnderConstruction = new ArrayList<>();

        for (char mineChar : mines.toCharArray()) {
            if (mineChar == ROW_SEPARATOR) {
                cells.add(rowUnderConstruction);
                rowUnderConstruction = new ArrayList<>();
            } else {
                rowUnderConstruction.add(buildCell(mineChar));
            }
        }

        cells.add(rowUnderConstruction);

        return new Minefield(cells);
    }

    private static Cell buildCell(final char mineChar) {
        final boolean isArmed = (mineChar == MINE_SYMBOL);
        return new Cell(isArmed);
    }
}
