import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Test 1: " + Arrays.toString(solution.twoSum(nums1, target1))); // Output: [0, 1]

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Test 2: " + Arrays.toString(solution.twoSum(nums2, target2))); // Output: [1, 2]

        // Test Case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Test 3: " + Arrays.toString(solution.twoSum(nums3, target3))); // Output: [0, 1]
    }
}
