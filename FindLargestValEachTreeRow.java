// Time Complexity: O(n)
// Space Complexity: O(n)

// Level order traversal BFS
public class FindLargestValEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        List<Integer>result  = new ArrayList();
        int max = Integer.MIN_VALUE;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i= 0 ; i < size ; i++)
            {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        return result;
    }
}

// DFS 
public class FindLargestValEachTreeRow {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
           return result;
       dfs(root, 0);
       return result;
   }
   
   private void dfs(TreeNode root, int level)
   {
       // base case
       if(root == null)
           return;
       
       
       if(level == result.size())
       {
           result.add(root.val);
       }
       else
       {
           int max = Math.max(result.get(level), root.val);
           result.set(level, max);
       }
       
       dfs(root.left, level+1);
       dfs(root.right, level+1);
   }
}