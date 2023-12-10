// Time Complexity: O(mn) 
// Space Complexity: O(3mn)
// Approach 1
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Set<String> set = new HashSet<>();
        int m = board.length;
        int n = board[0].length;

        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer,  Set<Character>> col = new HashMap<>();
        Map<String,  Set<Character>> rc = new HashMap<>();

        for(int i=0; i<m; i++){
            for(int j=0; j< n; j++){
                char c = board[i][j];
                if(c != '.'){

                    // Row check
                    if(!row.containsKey(i)){
                        row.put(i, new HashSet());
                        row.get(i).add(c);
                    }else{
                        if(row.get(i).contains(c)) return false;
                        else row.get(i).add(c);
                    }

                    // Column check
                    if(!col.containsKey(j)){
                        col.put(j, new HashSet());
                        col.get(j).add(c);
                    }else{
                        if(col.get(j).contains(c)) return false;
                        else col.get(j).add(c);
                    }

                    // 3 x 3 sub box check
                    String s = i/3 + " " + j/3;
                    if(!rc.containsKey(s)){
                        rc.put(s, new HashSet());
                        rc.get(s).add(c);
                    }else{
                        if(rc.get(s).contains(c)) return false;
                        else rc.get(s).add(c);
                    }

                }
            }
        }

        return true;

    }
}


// Time Complexity: O(mn) 
// Space Complexity: O(mn)
// Approach 2
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char c = board[i][j];
                if(c != '.'){
                    if(!set.add(c + " row: " + i) || !set.add(c + " column: " + j) || !set.add(c + " row: " + i/3 + " column: " + j/3)){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}