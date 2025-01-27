//Time Complexity : O(n)
//Space Complexity : O(1)
class LargestValue {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size() !=1){
            TreeNode temp = q.poll();
            if(temp!=null){
                max = Math.max(max,temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }else{
                result.add(max);
                max = Integer.MIN_VALUE;
                q.add(null);
            }
        }
        result.add(max);
        return result;

    }
}