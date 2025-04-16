// import java.util.HashSet;
// import java.util.Set;

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Set<Character> set = new HashSet<>();
//         int maxLen = 0;
//         int left = 0;
//         int n = s.length();
        
//         for (int right = 0; right < n; right++) {
//             char c = s.charAt(right);
            
//             // If character exists in set, move left pointer
//             while (set.contains(c)) {
//                 set.remove(s.charAt(left++));
//             }
            
//             set.add(c);
//             maxLen = Math.max(maxLen, right - left + 1);
            
//             // Early termination if remaining characters can't beat current max
//             if (maxLen >= n - left) {
//                 break;
//             }
//         }
        
//         return maxLen;
//     }
// }


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        int n = s.length();
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            
            // If character exists in set, move left pointer
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
            
            // Early termination if remaining characters can't beat current max
            if (maxLen >= n - left) {
                break;
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Standard test cases
        String[] testCases = {
            "abcabcbb",  // 3 ("abc")
            "bbbbb",     // 1 ("b")
            "pwwkew",    // 3 ("wke")
            "",          // 0 (empty string)
            " ",         // 1 (single space)
            "au",        // 2 ("au")
            "dvdf",      // 3 ("vdf")
            "abba"       // 2 ("ab" or "ba")
        };
        
        // Edge cases
        String edgeCase1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 52 (all unique)
        String edgeCase2 = new String(new char[1000]).replace('\0', 'a'); // 1 (all same)
        
        System.out.println("=== Standard Test Cases ===");
        for (String testCase : testCases) {
            int result = solution.lengthOfLongestSubstring(testCase);
            System.out.printf("Input: \"%-15s\" → Output: %d%n", 
                            testCase.length() > 10 ? testCase.substring(0, 7) + "..." : testCase, 
                            result);
        }
        
        System.out.println("\n=== Edge Cases ===");
        System.out.printf("All unique chars (%d chars) → %d%n", 
                        edgeCase1.length(), 
                        solution.lengthOfLongestSubstring(edgeCase1));
        System.out.printf("All same chars (1000 'a's) → %d%n", 
                        solution.lengthOfLongestSubstring(edgeCase2));
        
        // Runtime test
        System.out.println("\n=== Runtime Test ===");
        long startTime = System.nanoTime();
        solution.lengthOfLongestSubstring(edgeCase1);
        long endTime = System.nanoTime();
        System.out.printf("Processed 52 unique chars in %d ns%n", endTime - startTime);
    }
}




