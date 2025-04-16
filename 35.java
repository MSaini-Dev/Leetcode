// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         int l = 0;
//         int r = nums.length - 1;
//         while (l <= r) {
//             int mid = l + (r - l) / 2;  
//             if (nums[mid] < target) {
//                 l = mid + 1;  
//             } 
//             else if (nums[mid] > target) {  
//                 r = mid - 1;
//             }
//             else {
//                 return mid;
//             }
//         }
//         return l; 
//     }
// }


class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;  
            if (nums[mid] < target) {
                l = mid + 1;  
            } 
            else if (nums[mid] > target) {  
                r = mid - 1;
            }
            else {
                return mid;
            }
        }
        return l; 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        int[][] testArrays = {
            {1, 3, 5, 6},  // Standard case
            {1},             // Single element
            {},              // Empty array
            {2, 4, 6, 8, 10}, // Even length
            {1, 3, 5, 7, 9, 11} // Odd length
        };
        
        int[] targets = {5, 2, 7, 0, 4, 12};
        
        System.out.println("Search Insert Position Test Results");
        System.out.println("----------------------------------");
        
        for (int[] nums : testArrays) {
            for (int target : targets) {
                int result = solution.searchInsert(nums, target);
                System.out.printf("Array: %-15s Target: %-3d → Position: %d%n",
                    java.util.Arrays.toString(nums),
                    target,
                    result);
            }
            System.out.println();
        }
        
        // Edge case: large array
        int[] largeArray = new int[1000000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i * 2;  // Even numbers 0 to 1,999,998
        }
        int largeTarget = 999999;
        long startTime = System.nanoTime();
        int largeResult = solution.searchInsert(largeArray, largeTarget);
        long endTime = System.nanoTime();
        
        System.out.println("\nPerformance Test:");
        System.out.printf("Large array (1,000,000 elements) - Target: %d → Position: %d%n",
            largeTarget, largeResult);
        System.out.printf("Execution time: %d nanoseconds%n", endTime - startTime);
    }
}