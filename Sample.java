// Time Complexity : O(n ^ 2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this


// Your code here along with comments explaining your approach


class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] boxes = new int[N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] - '0';
                int pos = 1 << (val - 1);

                if ((rows[r] & pos) > 0) {
                    return false;
                }
                rows[r] |= pos;

                if ((cols[c] & pos) > 0) {
                    return false;
                }
                cols[c] |= pos;

                int idx = (r / 3) * 3 + c / 3;
                if ((boxes[idx] & pos) > 0) {
                    return false;
                }
                boxes[idx] |= pos;
            }
        }
        return true;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

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