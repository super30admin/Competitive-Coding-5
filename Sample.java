// Find Largest Value in Each Tree Row
// Time Complexity : O(N)
// Space Complexity : O(N)
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public List<Integer> largestValues(TreeNode root) {
    //result
    List<Integer> result = new ArrayList<>();
    //null
    if(root == null)
        return result;
    
    //Queue
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        //size
        int size = q.size();
        //
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            TreeNode current = q.poll();
            max = Math.max(max,current.val);
            if(current.left!= null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }
           
        }
         result.add(max);
    }
        return result;
    }
}

// Valid Sudoku
//Time Complexity : O(1)
//Space Complexity : O(1)
class Solution2 {
    public boolean isValidSudoku(char[][] board) {
    //null case
        if (board == null || board.length != 9 || board[0].length != 9)
              return false;
        HashSet<String> seen = new HashSet();
        for ( int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                char c = board[i][j];
                //check for only cells containing numbers
                if (c != '.')
                {
                    //add return true if element not present 
                    //else return false
                    //so if it is not true return false
                  if (!seen.add(c + " found at row " + i) || !seen.add(c + " found at column " + j) || !seen.add(c + " found at box " + i/3 + "-" + j/3))
                     return false;
                }
            }
        }
        return true;
    }
}