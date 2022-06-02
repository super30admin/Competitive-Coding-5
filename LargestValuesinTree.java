// o(n) time || o(n) space

class Solution {

   public List<Integer> largestValues(TreeNode root) {

       List<Integer> result = new ArrayList<>();

       Queue<TreeNode> q = new LinkedList<>();

       if(root==null) return result;

       q.add(root);

       while(!q.isEmpty()){

           Integer max = null;

           int size = q.size();

           for(int i=0;i<size;i++){

               TreeNode node = q.poll();

               if(max==null)

                   max=node.val;

               if(max<node.val)

                   max=node.val;

               if(node.left!=null)

                   q.add(node.left);

               if(node.right!=null)

                   q.add(node.right);

           }

           result.add(max);

       }

       return result;

   }

}
