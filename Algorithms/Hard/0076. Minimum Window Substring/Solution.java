class Solution {
    public String minWindow(String s, String t) {
        int[] tCounts = new int[58];
        int have = 0, need = 0;
        for (char c : t.toCharArray()) {
            if (tCounts[c - 'A'] == 0) need++;
            tCounts[c - 'A']++;
        }

        int[] sCounts = new int[58];
        int minSize = Integer.MAX_VALUE;
        int[] result = {-1, -1};
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            if (increase(s.charAt(r), sCounts, tCounts)) {
                have++;
            }
            
            while (have == need) {
                if (r - l + 1 < minSize) {
                    minSize = r - l + 1;
                    result[0] = l;
                    result[1] = r;
                }
                
                if (decrease(s.charAt(l), sCounts, tCounts)) {
                    have--;
                }
                l++;
            }
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }

    private boolean increase(char c, int[] sCounts, int[] tCounts) {
        sCounts[c - 'A']++;
        return sCounts[c - 'A'] == tCounts[c - 'A'];
    }

    private boolean decrease(char c, int[] sCounts, int[] tCounts) {
        sCounts[c - 'A']--;
        return sCounts[c - 'A'] == tCounts[c - 'A'] - 1;
    }
}

