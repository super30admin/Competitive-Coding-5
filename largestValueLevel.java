// Time Complexity : O(N) N = number of Nodes
// Space Complexity : O(H) H = number of nodes in level with maxi,u, elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Do levelorder traversal and store the largestValues in arraylist
*/

// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int length = q.size();
            int maxLevelValue = Integer.MIN_VALUE;
            for(int i=0;i<length;i++) {
                TreeNode curr = q.poll();
                if(curr.val > maxLevelValue) maxLevelValue = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                
            }
            list.add(maxLevelValue);
        }
        return list;
    }
}
