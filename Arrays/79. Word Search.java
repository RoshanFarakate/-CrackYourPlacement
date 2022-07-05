class Solution {
	// to mark the chars which are visited in the process of traversing the adjacent numbers, so that we don't re-enter them.
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
		// converting the String to character array
        char[] words = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        
		// let us start traversing through the matrix
        for(int i = 0; i <board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == words[0] && traverse(board, i, j, words, 0)) return true;
            }
        }
        
        return false;
    }
    
    public boolean traverse(char[][] board, int i, int j, char[] words, int idx){
		// if we have found the full string, then return true
        if(idx == words.length) return true;
		
		// if the char is already visited OR out of bounds OR not same as our desired char, then return false;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != words[idx]) return false;
		
		// marking the char as visited since we will be using this char through our recursion
        visited[i][j] = true;
		
		// from a single cell, traversing and checking all the possible adjacent cells
        if(traverse(board, i, j+1, words, idx+1) ||
            traverse(board, i, j-1, words, idx+1) ||
            traverse(board, i+1, j, words, idx+1) ||
            traverse(board, i-1, j, words, idx+1)) return true;
			
		// backtracking to mark the char as not visited	
        visited[i][j] = false;
        return false;
    }
}
