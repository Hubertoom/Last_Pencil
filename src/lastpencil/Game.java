package lastpencil;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> playerList = List.of("John", "Jack");
    private int numberOfPencils;

    public void startGame() {
        numberOfPencils = getNumberOfPencils();
        int currentPlayerIndex = setFirstPlayer();

        while (numberOfPencils > 0) {
            System.out.println("|".repeat(numberOfPencils));
            System.out.printf("%s's turn\n", playerList.get(Math.abs(currentPlayerIndex)));
            currentPlayerIndex = 1 - currentPlayerIndex;
            numberOfPencils -= subtractPencils();
            if (numberOfPencils == 0) {
                System.out.printf("%s won!\n", playerList.get(currentPlayerIndex));
            }
        }
    }

    private int subtractPencils() {
        int pencilsToSubtract;
        while (true) {
            String input = scanner.nextLine();
            while (!isNumeric(input)) {
                System.out.println("Possible values: '1', '2' or '3'");
                input = scanner.nextLine();
            }

            pencilsToSubtract = Integer.parseInt(input);

            if (pencilsToSubtract < 1 || pencilsToSubtract > 3) {
                System.out.println("Possible values: '1', '2' or '3'");
            } else if (numberOfPencils - pencilsToSubtract < 0) {
                System.out.println("Too many pencils were taken");
            } else {
                break;
            }
        }
        return pencilsToSubtract;
    }

    private int setFirstPlayer() {
        System.out.println("Who will be the first (John, Jack):");
        String playerName = scanner.nextLine();
        while (!playerList.contains(playerName)) {
            System.out.println("Choose between 'John' and 'Jack'");
            playerName = scanner.nextLine();
        }
        return playerList.indexOf(playerName);
    }

    private int getNumberOfPencils() {
        System.out.println("How many pencils would you like to use:");
        while (true) {
            String input = scanner.nextLine();
            while (!isNumeric(input)) {
                System.out.println("The number of pencils should be numeric");
                input = scanner.nextLine();
            }

            numberOfPencils = Integer.parseInt(input);
            if (numberOfPencils == 0) {
                System.out.println("The number of pencils should be positive");
            } else {
                break;
            }
        }
        if (numberOfPencils < 0) {
            numberOfPencils = Math.abs(numberOfPencils);
        }
        return numberOfPencils;
    }

    private boolean isNumeric(String input) {
        return Pattern.matches("-?\\d+", input);
    }
}