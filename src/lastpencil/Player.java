package lastpencil;

public abstract class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract int getMove(int numberOfPencils);

    @Override
    public String toString() {
        return name;
    }
}