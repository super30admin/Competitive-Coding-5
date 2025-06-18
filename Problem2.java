class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>(); 
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                max = Math.max(node.val,max);

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                     q.add(node.right);
                }
            }
            result.add(max);
        }

        return result;
        
    }
}