package minesweeper;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MinefieldTest {
    @Test
    public void minefieldWithAMysteriousCellShouldBeMysterious() {
        Minefield minefield = MinefieldFactory.build("x");

        assertThat(minefield.getState(), is(Minefield.State.MYSTERIOUS));
    }

    @Test
    public void minefieldWithAnEmptyOpenCellShouldBeClear() {
        Minefield minefield = MinefieldFactory.build("x");
        minefield.open(0, 0);

        assertThat(minefield.getState(), is(Minefield.State.CLEAR));
    }

    @Test
    public void minefieldWithAnArmedOpenCellShouldBeDetonated() {
        Minefield minefield = MinefieldFactory.build("m");
        minefield.open(0, 0);

        assertThat(minefield.getState(), is(Minefield.State.DETONATED));
    }

    @Test
    public void minefieldWithMysteriousCellsAndNoArmedOpenCellShouldBeMysterious() {
        Minefield minefield = MinefieldFactory.build("xx,mx");
        minefield.open(0, 0);

        assertThat(minefield.getState(), is(Minefield.State.MYSTERIOUS));
    }

    @Test
    public void minefieldWithAFlaggedArmedCellShouldBeClear() {
        Minefield minefield = MinefieldFactory.build("m");
        minefield.flag(0, 0);

        assertThat(minefield.getState(), is(Minefield.State.CLEAR));
    }

    @Test
    public void minefieldWithAFlaggedEmptyCellShouldBeMysterious() {
        Minefield minefield = MinefieldFactory.build("x");
        minefield.flag(0, 0);

        assertThat(minefield.getState(), is(Minefield.State.MYSTERIOUS));
    }

    @Test
    public void detonatedMinefieldShouldHaveGameOverMessage() {
        Minefield minefield = MinefieldFactory.build("m");
        minefield.open(0, 0);

        assertThat(minefield.getMessage(), is("Oops, you stepped on a mine! Game over!"));
    }

    @Test
    public void clearedMinefieldShouldHaveVictoryMessage() {
        Minefield minefield = MinefieldFactory.build("x");
        minefield.open(0, 0);

        assertThat(minefield.getMessage(), is("Wow, you cleared the minefield! Game over!"));
    }

    @Test
    public void mysteriousCellShouldDisplayX() {
        Minefield minefield = MinefieldFactory.build("x");

        assertThat(minefield.toString(), is("x\n"));
    }

    @Test
    public void clearCellShouldDisplay0() {
        Minefield minefield = MinefieldFactory.build("x");
        minefield.open(0, 0);

        assertThat(minefield.toString(), is("0\n"));
    }

    @Test
    public void detonatedCellShouldDisplayM() {
        Minefield minefield = MinefieldFactory.build("m");
        minefield.open(0, 0);

        assertThat(minefield.toString(), is("m\n"));
    }

    @Test
    public void flaggedCellShouldDisplayF() {
        Minefield minefield = MinefieldFactory.build("m");
        minefield.flag(0, 0);

        assertThat(minefield.toString(), is("f\n"));
    }

    @Test
    public void displayShouldShowAllCellsInAGrid() {
        Minefield minefield = MinefieldFactory.build("mxx,mxx,xxx");
        minefield.open(2, 2);
        minefield.flag(0, 0);
        minefield.open(0, 1);

        assertThat(minefield.toString(), is("fxx\nmxx\nxx0\n"));
    }
}