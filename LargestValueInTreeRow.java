//BFS
//TC: O(N)
//SC: O(N)
//Did it run successfully on Leetcode? : Yes
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList();
        if ( root == null)
            return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty())
        {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for ( int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null)
                    q.add(node.left);
                if(node.right!= null)
                    q.add(node.right);    
            }
            result.add(max);
        }
        return result;
    }
}

//DFS
//TC: O(N)
//SC: O(Height)
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
      result = new ArrayList();
        if ( root == null)
         return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level)
    {
        //base
        if ( root == null)
            return;
        //logic
        if (level == result.size())
            result.add(root.val);
        else
            result.set(level, Math.max(result.get(level), root.val));
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        
    }
}
