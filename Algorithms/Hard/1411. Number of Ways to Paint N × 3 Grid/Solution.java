class Solution {
    public int numOfWays(int n) {
        long twos = 6, threes = 6;
        for (int i = 1; i < n; i++) {
            long newTwos = (twos * 3 + threes * 2) % 1000000007;
            long newThrees = ((twos + threes) * 2) % 1000000007;

            twos = newTwos;
            threes = newThrees;
        }
        return (int)((twos + threes) % 1000000007);
    }
}
