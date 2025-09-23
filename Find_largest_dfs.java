// Time Complexity :O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We perform DFS Traversal to identify the largest value at each row
//We add the values of the nodes visited if the size of result and level are same 
//If not we compare the value with already available value in that level and update the maximum between them in the result list

class Solution {
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<Integer> res) {
        //base
        if(root == null) return;
        //logic
        if(res.size() == level) { //no nodes from that level is present in list
            res.add(root.val);
        } else {// update the val in result with the max value at each row
            res.set(level, Math.max(root.val, res.get(level)));
        }

        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }
}
