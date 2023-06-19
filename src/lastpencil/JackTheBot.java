package lastpencil;

import java.util.Random;

public class JackTheBot extends Player {

    public JackTheBot(String name) {
        super(name);
    }

    @Override
    public int getMove(int numberOfPencils) {
        if (numberOfPencils == 1) return 1;
        return switch (numberOfPencils % 4) {
            case 0 -> 3;
            case 2 -> 1;
            case 3 -> 2;
            default -> new Random().nextInt(1, 4);
        };
    }
}