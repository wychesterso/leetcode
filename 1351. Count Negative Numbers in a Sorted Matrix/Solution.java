class Solution {
    public int countNegatives(int[][] grid) {
        int sum = 0;
        int m = grid[0].length, n = grid.length;
        int x = 0, y = grid.length - 1;

        while (x < m && y >= 0) {
            if (grid[y][x] < 0) {
                sum += m - x;
                // move up one row
                y--;
            } else {
                // move to the right
                x++;
            }
        }

        return sum;
    }
}
