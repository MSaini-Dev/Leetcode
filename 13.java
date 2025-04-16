// class Solution {
//     int value(char r) {
//         if (r == 'I')
//             return 1;
//         if (r == 'V')
//             return 5;
//         if (r == 'X')
//             return 10;
//         if (r == 'L')
//             return 50;
//         if (r == 'C')
//             return 100;
//         if (r == 'D')
//             return 500;
//         if (r == 'M')
//             return 1000;
//         return -1;
//         }
        
//     public int romanToInt(String s) {
//         int result =0, sbl1 , sbl2;
//          for (int i = 0; i < s.length(); i++) {
//             sbl1 = value(s.charAt(i));
//                 if (i + 1 < s.length()) {
//                     sbl2 = value(s.charAt(i + 1));
//                     if(sbl2>sbl1){
//                         result -= sbl1;
//                     }
//                     else{
//                         result+=sbl1;
//                     }
//                 }
//                 else {
//                     result += sbl1;
//                 }
//          }
//          return result;
//     }
// }



class Solution {
    // Improved with switch statement for better readability
    int value(char r) {
        return switch (r) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Invalid Roman numeral: " + r);
        };
    }
    
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentVal = value(s.charAt(i));
            
            if (i + 1 < s.length()) {
                int nextVal = value(s.charAt(i + 1));
                if (nextVal > currentVal) {
                    result -= currentVal;
                } else {
                    result += currentVal;
                }
            } else {
                result += currentVal;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String[] testCases = {
            "III",     // 3
            "IV",      // 4
            "IX",      // 9
            "LVIII",   // 58
            "MCMXCIV", // 1994
            "XL",      // 40
            "XC",      // 90
            "CD",      // 400
            "CM"       // 900
        };
        
        for (String testCase : testCases) {
            int result = solution.romanToInt(testCase);
            System.out.printf("Input: %-7s Output: %d%n", testCase, result);
        }
        
        // Edge case testing
        try {
            System.out.println(solution.romanToInt("Z")); // Invalid character
        } catch (IllegalArgumentException e) {
            System.out.println("Caught invalid character: " + e.getMessage());
        }
    }
}