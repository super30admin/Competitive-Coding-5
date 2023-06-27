// Time Complexity - O(MxN) as even if the while and for loops are there we traverse all the elements i.e the 81 elements. Its just the way we traverse those elements in 3x3 blocks //confirm once
// Space Complexity - O(9) as hashset has 9 elemnts max hence approx - O(1) // confirm once
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        // check all rows
        for(int i=0;i<m;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<n;j++){
                if(set!=null && board[i][j]!='.' && set.contains(board[i][j])){
                    return false;
                }else if(board[i][j]!='.'){
                    set.add(board[i][j]);
                }
            }
        }

        // check all columns
        for(int i=0;i<n;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<m;j++){
                // System.out.println(i+" "+j);
                if(set!=null && board[j][i]!='.' && set.contains(board[j][i])){
                    return false;
                }else if(board[j][i]!='.'){
                    set.add(board[j][i]);
                }
            }
        }

        // check each 3x3 box
        int a = 0;
        while(a<=6){
            int b = 0;
            HashSet<Character> set = new HashSet<>();
            while(b<=6){
                set = new HashSet<>();
                for(int i=0+a;i<=2+a;i++){
                    for(int j=0+b;j<=2+b;j++){
                        // System.out.println(i+" "+j);
                        if(set!=null && board[i][j]!='.' && set.contains(board[i][j])){
                            return false;
                        }else if(board[i][j]!='.'){
                            set.add(board[i][j]);
                        }
                    }
                }
                // System.out.println("Hello");
                b+=3;
            }
            a+=3;
        }
        return true;
    }
}