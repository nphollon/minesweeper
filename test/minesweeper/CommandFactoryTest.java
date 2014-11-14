package minesweeper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class CommandFactoryTest {
    @Mock
    private Minefield game;

    @Test
    public void commandFactoryShouldParseOAsOpen() {
        Command command = CommandFactory.build("o(0,1)");

        command.updateMinefield(game);

        verify(game).open(0, 1);
    }

    @Test
    public void commandFactoryShouldParseFAsFlag() {
        Command command = CommandFactory.build("f(0,1)");

        command.updateMinefield(game);

        verify(game).flag(0, 1);
    }

    @Test
    public void commandFactoryShouldParseOtherLettersAsNoCommand() {
        Command command = CommandFactory.build("x(0,1)");

        command.updateMinefield(game);

        verifyZeroInteractions(game);
    }

    @Test
    public void openShouldInterpretIntegerPairAsCoordinates() {
        Command command = CommandFactory.build("o (12, 13)");

        command.updateMinefield(game);

        verify(game).open(12, 13);
    }

    @Test
    public void flagShouldInterpretIntegerPairAsCoordinates() {
        Command command = CommandFactory.build("f (12, 13)");

        command.updateMinefield(game);

        verify(game).flag(12, 13);
    }
}