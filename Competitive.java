import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Competitive {
// Time Complexity : M*N
// Space Complexity : M*N
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//https://leetcode.com/problems/valid-sudoku/submissions/
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0) return false;
        HashSet<String> hs = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j] != '.'){
                    String row = board[i][j] + " at row " + i;
                String column = board[i][j] + " at column " + j;
                String subboard = board[i][j] + " at row " + i/3 + " at column "+j/3 ;
                if(hs.contains(row)|| hs.contains(column) || hs.contains(subboard)){
                    return false;
                }
                hs.add(row);
                hs.add(column);
                hs.add(subboard);
                }
                
            }
        }
        return true;
    }



// Time Complexity : N
// Space Complexity : N/2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
    List<Integer> result;
    
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root,int level){
        if(root == null) return;
        if(level == result.size()){
        result.add(root.val);
        }else{
            result.set(level,Math.max(root.val,result.get(level)));
        }
       dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}
