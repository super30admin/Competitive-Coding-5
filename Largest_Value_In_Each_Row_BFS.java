Time Complexity: O(n)
Space Complexity: O(n)

class Solution {
    
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        
        if(root == null)
            return list;
        
        int max = Integer.MIN_VALUE;
        
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
    
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                TreeNode temp = q.poll();
                max = Math.max(max, temp.val);
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            
            list.add(max);
            max = Integer.MIN_VALUE;
        }
        
        return list;
    }
}
