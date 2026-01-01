class Solution {
    int n = 0;
    char[][] pyramid;
    Map<String, List<Character>> allowedMap = new HashMap<>();
    Set<String> seen = new HashSet<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        n = bottom.length();
        pyramid = new char[n][n];
        for (int i = 0; i < n; i++) {
            pyramid[n - 1][i] = bottom.charAt(i);
        }

        for (String string : allowed) {
            allowedMap.computeIfAbsent(string.substring(0, 2), k -> new ArrayList<>()).add(string.charAt(2));
        }

        return helper(n - 1, 0);
    }

    private boolean helper(int row, int col) {
        if (row == 0) {
            // base case - all blocks filled
            return true;
        } else if (col == row) {
            // memoization
            String s = new String(pyramid[row - 1]);
            if (seen.contains(s)) return false;
            seen.add(s);

            // move to next row
            return helper(row - 1, 0);
        }

        String key = String.valueOf(pyramid[row][col]) + pyramid[row][col + 1];
        if (!allowedMap.containsKey(key)) return false;

        for (char c : allowedMap.get(key)) {
            pyramid[row - 1][col] = c;
            if (helper(row, col + 1)) return true;
            pyramid[row - 1][col] = '\u0000'; // backtrack
        }

        return false;
    }
}
