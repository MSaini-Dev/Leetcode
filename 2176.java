// class Solution {
//     public int countPairs(int[] nums, int k) {
//         int count = 0;
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) { // start j from i + 1 to ensure i < j
//                 if (nums[i] == nums[j] && (i * j) % k == 0) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

public class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 1, 2, 2, 2, 1, 3};
        int k1 = 2;
        System.out.println("Output 1: " + sol.countPairs(nums1, k1));  // Expected: 4

        int[] nums2 = {1, 2, 3, 4};
        int k2 = 1;
        System.out.println("Output 2: " + sol.countPairs(nums2, k2));  // Expected: 0
    }
}
