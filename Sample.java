// Problem 1 - Valid Sudoku
// Time Complexity : O(n * n) where n = number of rows and columns as they are equal
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Algorithm
// 1 - iterate through the rows
// 2 - initiliaze a hashset
// 3 - iterate through columns
// 4 - check for filled cell and if the character is present in the set, return false
// 5 - iterate through the board
// 6 - get indices for 3x3 matrix
// 7 - check for filled cell and if the character is present in the set, return false
class Solution {
  public boolean isValidSudoku(char[][] board) {
    // 1
    for (int i=0; i<board.length; i++) {
      // 2
      HashSet<String> set = new HashSet<>();
      // 3
      for (int j=0; j<board[0].length; j++) {
        // 4
        if ((board[i][j] != '.' && !set.add("r" + board[i][j])) || (board[j][i] != '.' && !set.add("c" + board[j][i]))) {
          return false;
        }
      }
    }
    
    // 5
    for (int i=0; i<board.length; i+=3) {
      for(int j=0; j<board[0].length; j+=3){
        HashSet<Character> set = new HashSet<Character>();

        for(int k=0; k<board.length; k++){
          // 6
          int cr = i + k / 3;
          int cc = j + k % 3;
          // 7
          if(board[cr][cc] != '.' && !set.add(board[cr][cc])){
            return false;
          } 
        }
      }
    }

    return true;
  }
}

// Problem 2 - Find Largest Value in Each Tree Row
// Time Complexity : O(n) where n = number of nodes
// Space Complexity : O(n) -> extra space for queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Algorithm
// 1 - base condition
// 2 - initiliaze a queue and root to it
// 3 - while condition
// 4 - get size of the queue
// 5 - initiliaze max
// 6 - iterate through the size
// 7 - get the front of the queue
// 8 - check if front's value is greater than max, then change max
// 9 - add front.left and front.right to queue if not null
// 10 - after iterating through the size, add the max obtained to output list
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
    // 1
    if (root == null) {
      return new ArrayList<>();
    }
    // 2
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    List<Integer> output = new ArrayList<>();
    // 3
    while (!queue.isEmpty()) {
      // 4
      int size = queue.size();
      // 5
      int max = Integer.MIN_VALUE;
      // 6
      for (int i=0; i<size; i++) {
        // 7
        TreeNode front = queue.poll();
        // 8
        if (front.val > max) {
          max = front.val;
        }
        // 9
        if (front.left != null) {
          queue.add(front.left);
        }
        if (front.right != null) {
          queue.add(front.right);
        }
      }
      // 10
      output.add(max);
    }

    return output;
  }
}
