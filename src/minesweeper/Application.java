package minesweeper;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the minefield layout: ");
        Minefield mines = MinefieldFactory.build(scanner.nextLine());

        while (mines.getState() == Minefield.State.MYSTERIOUS) {
            System.out.println(mines);
            System.out.println("Enter option: ");
            Command command = CommandFactory.build(scanner.nextLine());
            command.updateMinefield(mines);
        }

        System.out.println(mines);
        System.out.println(mines.getMessage());
    }

}
