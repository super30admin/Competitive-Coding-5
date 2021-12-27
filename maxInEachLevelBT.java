// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// Time Complexity = O(n)
// Time Complexity = O(n)
// BFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            int size=q.size();
            int max = Integer.MIN_VALUE;

            for (int i=0; i<size; i++){
                TreeNode node = q.poll();
                if (node.val > max) {
                    max = node.val;
                }

                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(max);
        }

        return result;
    }
}

// Time Complexity = O(n)
// Time Complexity = O(h)
// DFS
class Solution {
    List<Integer> result;
    int max;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, 0);

        return result;
    }

    private void dfs(TreeNode root, int lvl) {
        //base
        if (root == null) return;

        //logic
        if (result.size() == lvl) {
            result.add(root.val) ;
        }
        if (result.get(lvl) < root.val) {
            result.set(lvl, root.val);
        }

        //recurse
        dfs(root.left, lvl+1);
        dfs(root.right, lvl+1);
    }
}