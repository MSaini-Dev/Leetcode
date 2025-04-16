class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (dfs(board, word, 0, x, y, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        // Base case: whole word matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds or already visited or character doesn't match
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length ||
            visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        visited[x][y] = true;

        // Explore 4 directions
        boolean found = dfs(board, word, index + 1, x - 1, y, visited) || 
                        dfs(board, word, index + 1, x + 1, y, visited) || 
                        dfs(board, word, index + 1, x, y - 1, visited) || 
                        dfs(board, word, index + 1, x, y + 1, visited);   
        visited[x][y] = false; // Backtrack
        return found;
    }

}