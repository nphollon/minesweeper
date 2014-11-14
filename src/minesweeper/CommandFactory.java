package minesweeper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandFactory {
    public static Command build(final String userCommand) {
        List<Integer> coordinates = getCoordinates(userCommand);
        int x = coordinates.get(0);
        int y = coordinates.get(1);

        if (userCommand.charAt(0) == 'o') {
            return new OpenCommand(x, y);
        }
        if (userCommand.charAt(0) == 'f') {
            return new FlagCommand(x, y);
        }
        return new NoCommand();
    }

    private static List<Integer> getCoordinates(final String userCommand) {
        int openParenIndex = userCommand.indexOf('(');
        int closeParenIndex = userCommand.indexOf(')');
        String coordinatePair = userCommand.substring(openParenIndex + 1, closeParenIndex).trim();

        return Arrays.stream(coordinatePair.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static class OpenCommand implements Command {
        private final int x;
        private final int y;

        public OpenCommand(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void updateMinefield(final Minefield game) {
            game.open(x, y);
        }
    }

    private static class FlagCommand implements Command {
        private final int x;
        private final int y;

        public FlagCommand(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void updateMinefield(final Minefield game) {
            game.flag(x, y);
        }
    }

    private static class NoCommand implements Command {
        @Override
        public void updateMinefield(final Minefield game) {
            // do nothing
        }
    }
}
