// import java.util.Stack;

// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();

//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if (ch == '(' || ch == '{' || ch == '[') {
//                 stack.push(ch);
//             }
//             else if (ch == ')' || ch == '}' || ch == ']') {
//                 if (stack.isEmpty()) {
//                     return false;
//                 }
//                 char top = stack.pop();
//                 if ((ch == ')' && top != '(') ||
//                     (ch == '}' && top != '{') ||
//                     (ch == ']' && top != '[')) {
//                     return false;
//                 }
//             }
//         }
//         return stack.isEmpty();
//     }
// }


import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String[] testCases = {
            "()",        // true
            "()[]{}",    // true
            "(]",        // false
            "([)]",     // false
            "{[]}",      // true
            "",          // true (empty is valid)
            "[",         // false (unclosed)
            "]",         // false (unopened)
            "([]){",    // false
            "((()))",    // true
            "([{}])",    // true
            "([{)]}"    // false
        };

        System.out.println("Parentheses Validation Results:");
        System.out.println("-------------------------------");
        
        for (String testCase : testCases) {
            boolean result = solution.isValid(testCase);
            System.out.printf("Input: %-10s → %-6s → %s%n",
                "\"" + testCase + "\"",
                result,
                result ? "✓ Valid" : "✗ Invalid");
        }

        // Additional edge case
        try {
            String nullCase = null;
            System.out.println("\nTesting null input...");
            solution.isValid(nullCase);
        } catch (NullPointerException e) {
            System.out.println("Handled null input: " + e.getMessage());
        }
    }
}
