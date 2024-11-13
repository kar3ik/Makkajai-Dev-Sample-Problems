import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grid {
    private Set<Cell> liveCells;

    public Grid(Set<Cell> initialCells) {
        this.liveCells = initialCells;
    }

    public Set<Cell> getLiveCells() {
        return liveCells;
    }

    public Set<Cell> getNeighbors(Cell cell) {
        Set<Cell> neighbors = new HashSet<>();
        int[] deltas = {-1, 0, 1};
        for (int dx : deltas) {
            for (int dy : deltas) {
                if (dx != 0 || dy != 0) {
                    neighbors.add(new Cell(cell.getX() + dx, cell.getY() + dy));
                }
            }
        }
        return neighbors;
    }

    public Grid nextGeneration() {
        Map<Cell, Integer> neighborCounts = new HashMap<>();

        // Count live neighbors for each cell
        for (Cell cell : liveCells) {
            for (Cell neighbor : getNeighbors(cell)) {
                neighborCounts.put(neighbor, neighborCounts.getOrDefault(neighbor, 0) + 1);
            }
        }

        Set<Cell> newLiveCells = new HashSet<>();

        // Apply rules to determine the next generation of live cells
        for (Map.Entry<Cell, Integer> entry : neighborCounts.entrySet()) {
            Cell cell = entry.getKey();
            int count = entry.getValue();
            if (count == 3 || (count == 2 && liveCells.contains(cell))) {
                newLiveCells.add(cell);
            }
        }

        return new Grid(newLiveCells);
    }
}
