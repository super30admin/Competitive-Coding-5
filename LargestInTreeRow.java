class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<Integer> list=new LinkedList<Integer>();
        
        //base condition
        if(root==null){
            return list;
        }
        
        
       // int max=Integer.MIN_VALUE;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
           int max=Integer.MIN_VALUE;
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                
                TreeNode node=queue.poll();
                if(node.val>max) max=node.val;
                if(node.left!=null) queue.offer(node.left);
                
                if(node.right!=null) queue.offer(node.right);
                
            }
            
            
            list.add(max);
        }
        
        return list;
    }
}
