// Time Complexity : O(n)
// Space Complexity : O(max nodes in a level) for the queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MaxLevel{

    public List<Integer> maxLevel(TreeNode root){
        if(root == null) return new ArrayList<>();

        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            int maxValue=Integer.MIN_VALUE;
            for(int i=0;i<s;i++){
                TreeNode temp=q.poll();
                maxValue=Math.max(maxValue,temp.val);

                if(temp.left!=null){
                    q.add(temp.left)
                }
                if(temp.right!=null){
                    q.add(temp.right)
                }

            }
            res.add(maxValue);
        }
        return res;
    }
}