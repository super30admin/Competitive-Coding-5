// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList();
        
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            max = Integer.MIN_VALUE;
            for(int i = 0; i < sz; i++) {
                TreeNode current = queue.poll();
                max = Math.max(max, current.val);
                if(current.left!=null) {
                    queue.add(current.left);
                }
                if(current.right!=null) {
                    queue.add(current.right);
                }
                
            }
            result.add(max);
        }
       
        return result;
    }
}


// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    boolean result;
    public boolean isValidSudoku(char[][] board) {
        result = true;
        if(board == null || board.length == 0) {
            result = true;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            int[] freq = new int[10];
            for(int j = 0; j < n; j++) {
                if(board[i][j] != '.') {
                    int current = board[i][j] - '0'; 
                    freq[current]++;
                }
            }
            for(int k = 0; k < freq.length; k++) {
                //System.out.println(Arrays.toString(freq));
                if(freq[k] > 1) {
                    result = false;  
                }
            }
        }
        for(int j = 0; j < n; j++) {
            int[] freq = new int[10];
            for(int i = 0; i < m; i++) {
                if(board[i][j] != '.') {
                    int current = board[i][j] - '0'; 
                    freq[current]++;
                }
            }
            for(int k = 0; k < freq.length; k++) {
                //System.out.println(Arrays.toString(freq));
                if(freq[k] > 1) {
                    result = false;  
                }
            }
        }
        
        checker(board, 0, 3, 0, 3);
        checker(board, 0, 3, 3, 6);
        checker(board, 0, 3, 6, 9);
        checker(board, 3, 6, 0, 3);
        checker(board, 3, 6, 3, 6);
        checker(board, 3, 6, 6, 9);
        checker(board, 6, 9, 0, 3);
        checker(board, 6, 9, 3, 6);
        checker(board, 6, 9, 6, 9);
        return result;
    }
    private void checker(char[][] board,int startRow,int endRow, int startColumn, int endColumn) {
        
        int[] freq = new int[9];
        
        for(int i = startRow; i < endRow; i++) {
            for(int j = startColumn; j < endColumn; j++) {
                if(board[i][j] != '.') {
                    int current = board[i][j] - '0';
                    freq[current-1]++;
                }
            }
        }
        for(int k = 0; k < freq.length; k++) {
            //System.out.println(Arrays.toString(freq));
            if(freq[k] > 1) {
                result = false;
            }
        }
    }
}

