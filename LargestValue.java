// Time Complexity : O(n)
//Space Complexity : O(W) the width of the tree 
//Did this code successfully run on Leetcode : Yes
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> maxList = new ArrayList<>();
        if(root == null) return maxList;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            int maxValue = Integer.MIN_VALUE;
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                
                if(curr.val > maxValue){
                    maxValue = curr.val;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            
            maxList.add(maxValue);
        }
        
        return maxList;
    }
}