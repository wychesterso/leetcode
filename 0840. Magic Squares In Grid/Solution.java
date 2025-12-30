class Solution {
    // PATTERN
    // elements on the border must be in sequence 61834927
    // corners must be even
    String magicBorder = "618349276183492";
    String magicBorderReversed = "729438167294381";

    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if (row < 3 || col < 3) return 0;

        int count = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (isMagic(grid, i, j)) count++;
            }
        }
        return count;
    }
    
    private boolean isMagic(int[][] grid, int startRow, int startCol) {
        // middle element must be 5
        if (grid[startRow + 1][startCol + 1] != 5) return false;

        // corner elements must be even
        if (grid[startRow][startCol] % 2 != 0) return false;

        // border elements must follow the pattern
        int[] borderX = new int[]{0, 0, 0, 1, 2, 2, 2, 1};
        int[] borderY = new int[]{0, 1, 2, 2, 2, 1, 0, 0};

        StringBuilder border = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int num = grid[startRow + borderX[i]][startCol + borderY[i]];
            if (num > 9) return false;
            border.append(num);
        }

        return magicBorder.contains(border) || magicBorderReversed.contains(border);
    }
}
