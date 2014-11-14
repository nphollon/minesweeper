package minesweeper;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MinefieldFactoryTest {
    private static final Cell EMPTY_CELL = new Cell(false);
    private static final Cell ARMED_CELL = new Cell(true);

    @Test
    public void oneXShouldBecomeEmpty1x1Minefield() {
        List<List<Cell>> cells = asList(asList(EMPTY_CELL));

        final Minefield minefield = MinefieldFactory.build("x");

        assertThat(minefield.getCells(), is(cells));
    }

    @Test
    public void fourXsShouldBecomeEmpty2x2Minefield() {
        List<List<Cell>> cells = asList(asList(EMPTY_CELL, EMPTY_CELL), asList(EMPTY_CELL, EMPTY_CELL));

        final Minefield minefield = MinefieldFactory.build("xx,xx");

        assertThat(minefield.getCells(), is(cells));
    }

    @Test
    public void anMShouldBecomeAHiddenMine() {
        List<List<Cell>> cells = asList(asList(ARMED_CELL));

        final Minefield minefield = MinefieldFactory.build("m");

        assertThat(minefield.getCells(), is(cells));
    }
}