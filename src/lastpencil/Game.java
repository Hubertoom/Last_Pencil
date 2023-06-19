package lastpencil;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        System.out.println("How many pencils would you like to use:");
        int numberOfPencils = Integer.parseInt(scanner.nextLine());

        System.out.println("Who will be the first (John, Jack):");
        String firstPlayer = scanner.nextLine();

        System.out.println("|".repeat(numberOfPencils));
        System.out.println(firstPlayer + " is going first!");
    }
}
