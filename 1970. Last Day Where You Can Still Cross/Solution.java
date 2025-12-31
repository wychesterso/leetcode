class Solution {
    int row = 0;
    int col = 0;
    int[] dirX = new int[]{0, 0, 1, -1};
    int[] dirY = new int[]{1, -1, 0, 0};

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row;
        this.col = col;
        int len = cells.length;

        int[][] grid = new int[row][col];
        for (int i = 0; i < len; i++) {
            int r = cells[len - 1 - i][0] - 1, c = cells[len - 1 - i][1] - 1;
            if (r == 0 || checkNeighbours(grid, r, c)) {
                grid[r][c] = 2;
                if (dfs(grid, r, c)) return len - 1 - i;
            } else {
                grid[r][c] = 1;
            }
        }
        return 0;
    }

    private boolean checkNeighbours(int[][] grid, int row, int col) {
        for (int i = 0; i < 4; i++) {
            int newRow = row + dirX[i];
            int newCol = col + dirY[i];
            if (!checkBounds(newRow, newCol)) continue;

            if (grid[newRow][newCol] == 2) return true;
        }
        return false;
    }

    private boolean checkBounds(int row, int col) {
        return !(row < 0 || row >= this.row || col < 0 || col >= this.col);
    }

    private boolean dfs(int[][] grid, int row, int col) {
        if (row == grid.length - 1) return true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirX[i];
            int newCol = col + dirY[i];
            if (checkBounds(newRow, newCol) && grid[newRow][newCol] == 1) {
                grid[newRow][newCol] = 2;
                if (dfs(grid, newRow, newCol)) return true;
            }
        }
        return false;
    }
}
