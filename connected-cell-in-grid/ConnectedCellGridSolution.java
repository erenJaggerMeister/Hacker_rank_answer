import java.util.*;

public class ConnectedCellGridSolution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        // Initialize matrix using List<List<Integer>>
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }

        int result = Solution.connectedCell(matrix);
        System.out.println(result);
    }
}

class Solution {
    // 8 directions (N, NE, E, SE, S, SW, W, NW)
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int connectedCell(List<List<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        boolean[][] visited = new boolean[rows][cols];
        int maxRegion = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix.get(i).get(j) == 1 && !visited[i][j]) {
                    int size = dfs(matrix, visited, i, j);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }

        return maxRegion;
    }

    private static int dfs(List<List<Integer>> matrix, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        int count = 1; // count current cell

        for (int dir = 0; dir < 8; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (isValid(matrix, visited, nx, ny)) {
                count += dfs(matrix, visited, nx, ny);
            }
        }

        return count;
    }

    private static boolean isValid(List<List<Integer>> matrix, boolean[][] visited, int x, int y) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        return x >= 0 && x < rows &&
               y >= 0 && y < cols &&
               matrix.get(x).get(y) == 1 &&
               !visited[x][y];
    }
}
