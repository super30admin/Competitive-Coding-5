// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j]!='.'){
                    if(!(set.add(board[i][j]+" row found in "+i))||!(set.add(board[i][j]+" col found in "+j))||!(set.add(board[i][j]+" sub found in "+i/3+"-"+j/3)))
                        return false;
                }
            }
        }
        return true;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this
//DFS
class Solution {
    List<Integer> result;

    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<Integer>();
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth == result.size()) {
            result.add(root.val);
        } else {
            result.set(depth, Math.max(result.get(depth), root.val));
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}

// BFS
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr != null){
                    max = Math.max(max, curr.val);
                }

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}