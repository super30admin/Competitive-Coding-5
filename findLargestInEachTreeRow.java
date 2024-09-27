//time complexity: O(N)
//Space complexity: O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lValues=new ArrayList<>();
        dfs(root, 0, lValues);
        return lValues;
    }
    public void dfs(TreeNode node, int level, List<Integer> lValues){
        //base case
        if(node==null)
            return;
        if(lValues.size()==level){
            lValues.add(node.val);
        }
        else{
            lValues.set(level, Math.max(lValues.get(level), node.val));
        }
        dfs(node.left, level+1, lValues);
        dfs(node.right, level+1, lValues);
    }
}