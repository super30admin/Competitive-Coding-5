// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Using BFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return new ArrayList<>();

        q.add(root);
         
        List<Integer> result = new ArrayList<>(); 
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int len = q.size();

            for (int i=0; i<len;i++){
                TreeNode currNode =  q.remove();
                max = Math.max(currNode.val,max);
                if(currNode.left!=null){
                    q.add(currNode.left);

                }
                if(currNode.right!=null){
                    q.add(currNode.right);

                }
            }
            result.add(max);
        }
        return result;
        
    }
}