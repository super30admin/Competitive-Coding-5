public class Problem2 {
    //t.c -> O(n)
    //s.c - >O(n)
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size =  q.size();
            if(size == 1){
                TreeNode value = q.poll();
                ans.add(value.val);
                if(value.left != null){
                    q.add(value.left);
                }
                if(value.right != null){
                    q.add(value.right);
                }
            }
            else{
                int max = Integer.MIN_VALUE;
                for(int i = 0 ;i<size;i++){
                    TreeNode value1 = q.poll();
                    max = value1.val > max ? value1.val : max;
                    if(value1.left != null){
                        q.add(value1.left);
                    }
                    if(value1.right != null){
                        q.add(value1.right);
                    }
                }
                ans.add(max);
            }
        }
        return ans;
    }
}
