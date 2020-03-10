// Time Complexity : O(H)=O(N) for skewed tree
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> result = new LinkedList<>();
//         if (root == null)
//             return result;
        
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
    
        
//         while(!q.isEmpty())
//         {
//          int count=q.size();
//          int max=Integer.MIN_VALUE;
            
//             for(int i=0; i<count; i++)
//             {
//                 TreeNode cur=q.poll();
//                 if(cur.val > max)
//                     max=cur.val;
                
//                 if(cur.left != null)
//                     q.add(cur.left);
                
//                 if(cur.right != null)
//                     q.add(cur.right);
//             }
//             result.add(max);
//         }
//         return result;
//     }
// }

//DFS:

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root == null)
            return result;
        
        dfs(root, 0);
        
        for (int i=0; i<map.size(); i++)
            result.add(map.get(i));
        
        return result;
    }
    private void dfs(TreeNode node, int depth)
    {
        if(node == null){
            return;
        }
        
        if(map.containsKey(depth))
        {
            int temp=map.get(depth);
            if(node.val > temp)
                map.replace(depth, node.val);
        }
        else
        {
            map.put(depth, node.val); 
        }
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}