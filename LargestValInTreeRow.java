// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//DFS
class LargestValInTreeRow {
    List<Integer> result ;
    public List<Integer> largestValues(TreeNode root) {
        
        //BFS
        if(root==null) return new ArrayList<>();
         result = new ArrayList<>();
        
        dfs(root,0);
        return result;
       
    }
    
    private void dfs(TreeNode root, int level ){
        if(root==null)
            return;
        
        if(result.size()==level)
            result.add(root.val);
        else{
            if(root.val>result.get(level))
                result.set(level,root.val);
        }
        
        if(root.left!=null) dfs(root.left,level+1);
        if(root.right!=null) dfs(root.right,level+1);
        
        }
}

//BFS
// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        //BFS
        
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            Integer max = null;
            
            while(size!=0)
            {
                TreeNode node = q.poll();
                if(max==null)
                    max= node.val;                    
                if(max<node.val)
                    max = node.val;
                
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                size--;
            }
            result.add(max);
            
        }
        return result;
    }
}