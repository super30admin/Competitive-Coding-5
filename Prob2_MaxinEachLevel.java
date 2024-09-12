//TC : O(H) - height of the tree
//SC : O(N) Creating a Queue


class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)    return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(! queue.isEmpty()){
            int len = queue.size();
            
            List<Integer> temp = new ArrayList<>();
            
            for(int i = 1; i <= len; i++){
                TreeNode curr = queue.poll();
                
                temp.add(curr.val);
                
                if(curr.left != null)   queue.add(curr.left);
                
                if(curr.right != null)  queue.add(curr.right);
            }
            
            int max = Collections.max(temp);
            
            result.add(max);
            
        }
        
        return result;
        
    }
}