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
        
      maxValue(root,0, result);
        return result;
    }
    private void maxValue(TreeNode root, int currentLevel,List<Integer> result){
		
		if(root ==null){

			return;
			}
		//int max = Integer.MIN_VALUE;
		//logic
		if( currentLevel == result.size()){
			result.add(root.val);
		}
		else  {
			int temp = result.get(currentLevel);
			//result.get(currentLevel).add(Math.max(temp,root.val));
            result.set(currentLevel,Math.max(temp,root.val));
            // result.remove(result.size()-1);
			}

	maxValue(root.left, currentLevel+1,result);
	maxValue(root.right, currentLevel+1,result);
       
	}
}