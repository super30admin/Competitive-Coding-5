// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//time complexity o(n) n - no of nodes
//space o(logn) -- recursive stack space
class Solution {
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        // edge case
        if(root == null)
            return res;
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode root, int level) {
        //base case
        if(root == null)
            return;
        //logic
        if(res.size()==level) {
            res.add(root.val);
        }
        else if(root.val > res.get(level)){
            res.set(level, root.val);
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

//time o(1) as total elements are 81
//space o(1) atmost we are adding 81 elements in the set
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return false;
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j] != '.') {
                    boolean row_wise = set.add(board[i][j]+" in row "+i);
                    boolean col_wise = set.add(board[i][j]+" in col "+j);
                    boolean box_wise = set.add(board[i][j]+" in box pos "+i/3 + " "+j/3);
                    if(!row_wise || !col_wise || !box_wise)
                        return false;
                }
            }
        }
        return true;
    }
}