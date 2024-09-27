// Time Complexity : O(N) Where N is no of nodes in tree
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Recursive
class Solution {
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int currDepth) {

        if(root == null)
            return;

        if(currDepth >= res.size())
            res.add(root.val);
        else
            res.set(currDepth, Math.max(res.get(currDepth),root.val));

        dfs(root.left, currDepth+1);
        dfs(root.right, currDepth+1);

    }
}


// Iterative
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        queue.add(root);
        res.add(root.val);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.add(temp.left);
                    max = Math.max(max, temp.left.val);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                    max = Math.max(max, temp.right.val);
                }
            }
            if(!queue.isEmpty())
                res.add(max);
        }
        return res;
    }
}