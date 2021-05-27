// Time complexity - O(n)
// Space complexity - O(n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
        
        List<Integer> result = new ArrayList<>();

    if(root == null){
        
        return result;
    }

	Queue<TreeNode> q1 = new LinkedList<>();
	q1.add(root);
	
	while(!q1.isEmpty()){

	int sizeLevel = q1.size();
	int max = Integer.MIN_VALUE;
	
	
	for(int i =0; i < sizeLevel; i ++){
		
	TreeNode currentNode = q1.poll();
	int currentValue = currentNode.val;
	max = Math.max(max,currentValue);
	
	if(currentNode.left != null)
	{
		q1.add(currentNode.left);
	}
	
	if(currentNode.right != null)
	{
		q1.add(currentNode.right);
	}

	

}
	result.add(max);
        
    }
        
        return result;
}
}