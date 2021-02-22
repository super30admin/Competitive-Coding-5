package MockInterviews.CompetitiveCoding5;

import java.util.ArrayList;
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

  // Successfully ran on leetcode.
  // time complexity: O(n)
  // space complexity : O(n) . Recursion uses stack.
  // Used  DFS approach to solve the problem.


class FindLargestValueInEachTreeRow {
    List<Integer> maxList = new ArrayList<Integer>();
    public List<Integer> largestValues(TreeNode root) {

        getMaxDFS(root, 0);
        return maxList;
    }

    private void getMaxDFS(TreeNode root, int level){
        if(root == null)
            return;
        if(level == maxList.size()){
            maxList.add(root.val);
        }else{
            if(root.val > maxList.get(level))
                maxList.set(level,root.val );
        }

        getMaxDFS(root.left, level+1);
        getMaxDFS(root.right, level+1);

    }
}

// Successfully ran on leetcode.
// time complexity: O(n)
// space complexity : O(n) . Queue uses extra space.
// Used  BFS approach to solve the problem.

class FindLargestValueInEachTreeRowBFS {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxList = new ArrayList<>();

        if(root == null)
            return maxList;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while( !queue.isEmpty()){
            int max = Integer.MIN_VALUE;

            int levelNodeLength = queue.size();

            for(int i=0; i<levelNodeLength; i++){
                TreeNode temp = queue.remove();

                if(temp.val > max)
                    max = temp.val;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }

            maxList.add(max);
        }
        return maxList;
    }
}

