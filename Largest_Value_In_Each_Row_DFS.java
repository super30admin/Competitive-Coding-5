Time Complexity: O(n)
Space Complexity: O(n)

//DFS
 class Solution {
  
     List<Integer> list = new ArrayList<>();
  
     public List<Integer> largestValues(TreeNode root) {
      
         if(root == null)
             return list;
      
      
         dfs(root, 0);
      
         return list;
      
     }
  
     private void dfs(TreeNode root, int depth)
     {
         if(root == null)
             return;
      
         if(list.size() > depth)
         {
             int num = Math.max(root.val, list.get(depth));
             list.set(depth, num);
         }else
         {
             list.add(root.val); 
         }
      
          dfs(root.left, depth + 1);
          dfs(root.right, depth + 1);
      
     }
 }
