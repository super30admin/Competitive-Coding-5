//Time complexity: O(N)
//Space Complexity: O(N)
//Accepted in first try on leetcode
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList();
        helper(root,res,0);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res, int level)
    {
        if(root== null)
        {
            return;
        }
        if(level==res.size())
        {
            res.add(root.val);
        }
        else
        {
            res.set(level, Math.max(res.get(level),root.val));
        }
        helper(root.left, res, level+1);
        helper(root.right, res, level+1);
    }
}