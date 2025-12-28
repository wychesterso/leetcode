class Solution {
    public int trap(int[] height) {
        int total = 0;

        int lp = 0, rp = height.length - 1, leftMax = 0, rightMax = 0;

        while (lp <= rp) {
            if (leftMax < rightMax) {
                int trapped = Math.min(leftMax, rightMax) - height[lp];
                if (trapped > 0) total += trapped;

                leftMax = Math.max(leftMax, height[lp++]);

            } else {
                int trapped = Math.min(leftMax, rightMax) - height[rp];
                if (trapped > 0) total += trapped;

                rightMax = Math.max(rightMax, height[rp--]);

            }
        }

        return total;
    }
}
