// TC: O(n)
//SC: O(n)

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lis= new ArrayList<>();
          if(root == null)
            return lis;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();
                max = Math.max(max,temp.val);

                if(temp.left!=null)
                    q.add(temp.left);

                if(temp.right!=null)
                    q.add(temp.right);

            }
            lis.add(max);
        }
        return lis;
    }
} 