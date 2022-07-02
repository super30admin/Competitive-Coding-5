/*
For this solution, we utilise BFS by using a level order traversal to traverse the tree. At each level, we
maintain a variable that keeps a track of the maximum value at current level, as well as a variable for 
tracking the size of the current level. We add the maximum value found at each level to a list and return it.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                max = Math.max(curr.val, max);
                
                if(curr.left != null)
                    q.add(curr.left);
                    
                if(curr.right != null)
                    q.add(curr.right);
            }
            
            result.add(max);
        }
        
        return result;
    }
}