class Solution {
    public int countNegatives(int[][] grid) {
        int sum = 0;
        int lp = 0;

        for (int i = grid.length - 1; i >= 0; i--) {
            int[] row = grid[i];
            int rp = row.length - 1;

            while (lp < rp) {
                int mp = lp + (rp - lp) / 2;
                if (row[mp] >= 0) {
                    // positive
                    lp = mp + 1;
                } else {
                    // negative
                    rp = mp;
                }
            }

            if (lp == row.length - 1 && row[lp] >= 0) {
                // no more negatives in grid
                return sum;
            }

            sum += row.length - lp;
        }

        return sum;
    }
}
