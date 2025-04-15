class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int a = 1, b = 2;

        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

    // Main method to test the climbStairs function
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] testCases = {1, 2, 3, 4, 5, 6, 8, 10};

        for (int n : testCases) {
            System.out.println("Steps: " + n + " → Ways to climb: " + sol.climbStairs(n));
        }
    }
}
