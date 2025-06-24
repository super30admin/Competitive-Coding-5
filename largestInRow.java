//DFS traversal, tracking the current level, and updates a result list by comparing and storing the maximum value at each level.
//It uses the size of the list to detect when a level is first visited and updates only when a larger value is found.
//Time complexity:O(n)
//Space complexity:O(h)


class Solution {

   public List<Integer> largestValues(TreeNode root) {

       List<Integer> result = new ArrayList<>();

       findMax(root,result,0);

       return result;

   }

   public void findMax(TreeNode root,List<Integer> result,int level){

       if(root==null) return;

       if(result.size()==level){

           result.add(root.val);

       }

       else result.set(level,result.get(level)<root.val?root.val:result.get(level));

       findMax(root.left,result,level+1);

       findMax(root.right,result,level+1);

   }

}