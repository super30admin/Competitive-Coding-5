// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    List<Integer> tmp;
    public List<Integer> largestValues(TreeNode root) {
        this.tmp = new ArrayList<>();
        helper(root,0);
        return tmp;
    }
    public void helper(TreeNode root, int level){
        if(root==null)
            return;
        if(level == tmp.size())
            tmp.add(root.val);
        else{
            int max = Math.max(root.val,tmp.get(level));
            tmp.set(level,max);
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}