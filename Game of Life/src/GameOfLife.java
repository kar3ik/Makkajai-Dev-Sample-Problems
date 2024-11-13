import java.util.HashSet;
import java.util.Set;

public class GameOfLife {
    private Grid grid;

    public GameOfLife(Set<Cell> initialCells) {
        this.grid = new Grid(initialCells);
    }

    public void tick() {
        grid = grid.nextGeneration();
    }

    public Set<Cell> getLiveCells() {
        return grid.getLiveCells();
    }

    public static Set<Cell> createInitialPattern(int[][] coordinates) {
        Set<Cell> initialCells = new HashSet<>();
        for (int[] coord : coordinates) {
            initialCells.add(new Cell(coord[0], coord[1]));
        }
        return initialCells;
    }
}
