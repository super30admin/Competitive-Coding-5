// Time Complexity : O(N) N = No. of nodes
// Space Complexity : O(Max width of the tree) = O(N/2) = O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// BFS Approach
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            int size = q.size();
            // level order traversal
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                max = Math.max(max,curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            res.add(max);
            max = Integer.MIN_VALUE;
        }
        return res;
    }
}

// DFS Recursive Approach || Time - O(n) || Space - O(h) h=ht of stack
// Using Recursion, add the level as an extra parameter to each recursive call and add the node of corresponding leve
// to the corresponding List.
// Now, at each level, find the max element and update whenever we find the new maximum corresponding to one level.
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        int level = 0;
        dfs(root, level, res);
        return res;
    }
    
    private void dfs(TreeNode root, int level, List<Integer> res) {
        if(root==null) return;
        if(res.size()==level) {
            res.add(root.val);
        } else {
            res.set(level,Math.max(res.get(level),root.val));
        }
        dfs(root.left,level+1,res);
        dfs(root.right,level+1,res);
    }
}