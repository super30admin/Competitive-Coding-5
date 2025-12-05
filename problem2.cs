/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<int> LargestValues(TreeNode root) {
        if(root == null) return new List<int>();
        Queue<TreeNode> levelQueue = new Queue<TreeNode>();
        levelQueue.Enqueue(root);
        List<int> result = new List<int>();
        while(levelQueue.Count>0)
        {
            int size = levelQueue.Count;
            int count=0;
            int max=int.MinValue;
            while(count<size)
            {
                TreeNode node = levelQueue.Dequeue();
                count++;
                max = Math.Max(max,node.val);
                if(node.left!=null)
                {
                levelQueue.Enqueue(node.left);
                }
                if(node.right!=null)
                {
                levelQueue.Enqueue(node.right);
                }
            }
            result.Add(max);      
        }
        return result;
        
    }
}