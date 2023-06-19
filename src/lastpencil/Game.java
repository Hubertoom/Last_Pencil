package lastpencil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Player> playerList = new ArrayList<>();
    private int numberOfPencils;

    public void startGame() {
        Player john = new JohnThePlayer("John");
        Player jack = new JackTheBot("Jack");
        playerList.add(john);
        playerList.add(jack);
        numberOfPencils = getNumberOfPencils();
        int currentPlayerIndex = setFirstPlayer();

        while (numberOfPencils > 0) {
            Player currentPlayer = playerList.get(currentPlayerIndex);
            System.out.println("|".repeat(numberOfPencils));
            System.out.printf("%s's turn!\n", currentPlayer);
            int playerMove = currentPlayer.getMove(numberOfPencils);

            // Printing the bot choice into the console, user choice is omitted
            if (currentPlayer.getName().equals("Jack")) {
                System.out.println(playerMove);
            }

            numberOfPencils -= playerMove;
            currentPlayerIndex = 1 - currentPlayerIndex;

            if (numberOfPencils == 0) {
                System.out.printf("%s won!\n", playerList.get(currentPlayerIndex));
            }
        }
    }

    private int setFirstPlayer() {
        System.out.println("Who will be the first (John, Jack):");
        String playerName = scanner.nextLine();

        while (!playerName.equals("John") && !playerName.equals("Jack")) {
            System.out.println("Choose between 'John' and 'Jack'");
            playerName = scanner.nextLine();
        }
        return playerName.equals("John") ? 0 : 1;
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