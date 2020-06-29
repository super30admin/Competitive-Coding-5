//Time Complexity:O(n)
//Space complexity:O(n)

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int max=Integer.MIN_VALUE;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                max=Math.max(node.val,max);
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