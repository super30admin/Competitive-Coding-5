import java.util.*;

public class FindLargestValueInEachTreeRow {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	//TC - o(n)
    //SC - o(n)
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        //edge case
        if(root == null)
            return result;
        //BFS traversal to get max of each level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            //assign max for each level 
            int max = Integer.MIN_VALUE;
            for(int i =0;i<size;i++){
                //traverse the queue and comare node values to find max val
                TreeNode node = q.poll();
                max = Math.max(max,node.val);
                //add left and right nodes for next traversal 
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            result.add(max);
        }
        
        return result;
    }

}
