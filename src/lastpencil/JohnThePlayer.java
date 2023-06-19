package lastpencil;

import java.util.Scanner;
import java.util.regex.Pattern;

public class JohnThePlayer extends Player {
    private final Scanner scanner = new Scanner(System.in);

    public JohnThePlayer(String name) {
        super(name);
    }

    @Override
    public int getMove(int numberOfPencils) {
        int userMove;
        while (true) {
            String input = scanner.nextLine();
            while (!Pattern.matches("-?\\d+", input)) {
                System.out.println("Possible values: '1', '2' or '3'");
                input = scanner.nextLine();
            }

            userMove = Integer.parseInt(input);

            if (userMove < 1 || userMove > 3) {
                System.out.println("Possible values: '1', '2' or '3'");
            } else if (numberOfPencils - userMove < 0) {
                System.out.println("Too many pencils were taken");
            } else {
                break;
            }
        }
        return userMove;
    }
}