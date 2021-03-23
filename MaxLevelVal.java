//Time Complexity: O(n)
//Space Complexity: O(height~=n) for DFS, O(n/2) for BFS.
//Executed on leetcode.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        
        if(root==null)
            return list;
        /*Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();	//
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++)
            {
                TreeNode levelNode = queue.poll(); // 2 
                if(levelNode.val>max)
                    max = levelNode.val;     //3
                if(levelNode.left!=null)
                    queue.add(levelNode.left); //5
                if(levelNode.right!=null)
                    queue.add(levelNode.right);    // ,5,3, 9     
            }
            list.add(max);            
        }
        
        return list;*/
        dfs(root,0);
        return list;        
    }
    
    void dfs(TreeNode root, int h)		//Adding root value to list at level. Tracking the level gives where the value goes in list.
    {
        if(list.size()==h)
            list.add(root.val);			//if the value in list at particular height is less than current value, replace it with current value.
        else
        {
            if(list.get(h)<root.val)
                list.set(h,root.val);
        }
        if(root.left!=null)
            dfs(root.left, h+1);
        if(root.right!=null)
            dfs(root.right, h+1);            
    }
}