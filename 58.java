class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String input1 = "Hello World";
        String input2 = "   fly me   to   the moon  ";
        String input3 = "luffy is still joyboy";

        System.out.println("Output 1: " + sol.lengthOfLastWord(input1)); // 5
        System.out.println("Output 2: " + sol.lengthOfLastWord(input2)); // 4
        System.out.println("Output 3: " + sol.lengthOfLastWord(input3)); // 6
    }
}
