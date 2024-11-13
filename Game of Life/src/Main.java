import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Define initial live cells for each test case
        int[][] inputA = {{1, 1}, {1, 2}, {2, 1}, {2, 2}};
        int[][] inputB = {{0, 1}, {1, 0}, {2, 1}, {0, 2}, {1, 2}};
        int[][] inputC = {{1, 1}, {1, 0}, {1, 2}};
        int[][] inputD = {{1, 1}, {1, 2}, {1, 3}, {2, 2}, {2, 3}, {2, 4}};

        // Run each test case
        System.out.println("Output A:");
        runGameOfLife(inputA);

        System.out.println("Output B:");
        runGameOfLife(inputB);

        System.out.println("Output C:");
        runGameOfLife(inputC);

        System.out.println("Output D:");
        runGameOfLife(inputD);
    }

    private static void runGameOfLife(int[][] initialPattern) {
        Set<Cell> initialCells = GameOfLife.createInitialPattern(initialPattern);
        GameOfLife game = new GameOfLife(initialCells);

        game.tick();  // Progress to the next generation

        Set<Cell> nextGenCells = game.getLiveCells();
        for (Cell cell : nextGenCells) {
            System.out.println(cell);
        }
        System.out.println();
    }
}
