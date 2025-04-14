import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] { 1 };
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] r = new int[digits.length + 1];
        r[0] = 1;
        return r;
    }

    // Main method to test plusOne
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
            {1, 2, 3},
            {9, 9, 9},
            {4, 3, 2, 1},
            {0},
            {}
        };

        for (int[] test : testCases) {
            int[] result = sol.plusOne(test);
            System.out.println("Input: " + Arrays.toString(test));
            System.out.println("Output: " + Arrays.toString(result));
            System.out.println();
        }
    }
}
