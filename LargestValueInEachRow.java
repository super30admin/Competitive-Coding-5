//TC = O(n)
//Space = O(n) ==>n/2 nodes in the queue

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int loopTheQueue = q.size();
            int max = Integer.MIN_VALUE; // min = -ve also till some range
            
            for(int i=0; i<loopTheQueue; i++){
                
                TreeNode curr = q.poll(); // 1
                System.out.println(curr); // reference of the node
                System.out.println(curr.val); // exact value of the node
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                
                max = Math.max(max, curr.val);
                
            }
            
            result.add(max);
            
        }
        return result;
        
    }
}
