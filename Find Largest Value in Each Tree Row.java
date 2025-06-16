// Time Complexity – O(n)
// // Space Complexity – O(h) 
//   where h is the height of the stack.
//   Not including the size of the output array

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, 0, result);
        return result;
    }
    void helper(TreeNode root, int level, List<Integer> res){
        // base
        if(root == null) return;
        // logic
        if(res.size() == level){
            res.add(root.val);
        }
        else{
            int max = Math.max(res.get(level), root.val);
            res.set(level,max);
        }
        helper(root.left, level+1,res);
        helper(root.right, level+1, res);
    }
}
