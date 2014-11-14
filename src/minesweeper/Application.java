package minesweeper;

import java.util.Scanner;

public class Application {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the minefield layout: ");
        Minefield mines = MinefieldFactory.build(getInputLine());

        while (mines.getState() == Minefield.State.MYSTERIOUS) {
            System.out.println("Enter option: ");
            String userCommand = getInputLine();
            Command command = CommandFactory.build(userCommand);
            command.updateMinefield(mines);
            System.out.println(mines.toString());
        }

        System.out.println(mines.toString());
        System.out.println(mines.getMessage());
    }

    private static String getInputLine() {
        return scanner.nextLine();
    }
}
