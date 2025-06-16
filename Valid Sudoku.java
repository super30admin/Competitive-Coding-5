// Time Complexity :O(9*9)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach:


class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        int M = 9;
        Set<String> charSet = new HashSet<>();

        for(int i = 0; i < N; i ++){
            for(int j = 0; j < M; j++){
                char currentChar = board[i][j];
                if (currentChar != '.'){
                    if(!charSet.contains(currentChar+"R"+i) && !charSet.contains(currentChar+"C"+j) && !charSet.contains(currentChar+"B"+i/3+j/3)){
                        charSet.add(currentChar+"R"+i);
                        charSet.add(currentChar+"C"+j);
                        charSet.add(currentChar+"B"+i/3+j/3);
                    }
                    else{
                        return false;
                    }
                    System.out.println(charSet.toString());
                }
            }
        }
        return true;

    }
}