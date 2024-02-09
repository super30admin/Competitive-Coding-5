//Aceepted on LT
//The idea is to have hashset for row column and square and keep adding anytime we repeat we return false
//Time should be O(mn)[size of matrix]
class Solution {

    Set<Character>[] rows = new Set[9];
    Set<Character>[] cols = new Set[9];
    Set<Character>[] s = new Set[9];

    public boolean isValidSudoku(char[][] board) {

        for(int i=0; i< rows.length; i++) rows[i] = new HashSet<>();
        for(int j=0; j< cols.length; j++) cols[j] = new HashSet<>();
        for(int k=0; k< s.length; k++) s[k] = new HashSet<>(); 

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                char c = board[i][j];
                if(c == '.') continue;

                if(rows[i].contains(c)) return false;
                else rows[i].add(c);
                 if(cols[j].contains(c)) return false;
                else cols[j].add(c);
                int idx = (3*(i/3)) + (j/3);
                if(s[idx].contains(c)) return false;
                else s[idx].add(c);
            }
        }
        return true;

    }
}