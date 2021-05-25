// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through all the levels and nodes
//Space Complexity: O(1) since we are not using extra space
class Solution {
    public List<Integer> largestValues(TreeNode root) {
          
        List<Integer> returnList = new ArrayList<>();
        
        if(root == null) return returnList;
        
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()){
            int size = treeQueue.size();

            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode curr = treeQueue.poll();
                if(curr.left != null){
                    treeQueue.add(curr.left);
                }
                
                if(curr.right != null){
                   treeQueue.add(curr.right);
                }                
                max = Math.max(max, curr.val); //Calculate max value at each level
            }           
            returnList.add(max);
        }
        
        return returnList;
    }
    
}