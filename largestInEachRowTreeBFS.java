package CompetitiveCoding5;

//TC - o(n)
//SC - o(n)

import CompetitiveCoding5.largestInEachRowTreeDFS.TreeNode;

public class largestInEachRowTreeBFS {
	
	
	//  Definition for a binary tree node.
	  public class TreeNode {
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
	  
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.val > max) max = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
}
