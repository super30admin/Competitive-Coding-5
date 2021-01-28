// Time Complexity : O(n), n is num of nodes
// Space Complexity : O(log n), stack space 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// use depth, pass result list to recursive fn, recurse on all tree nodes
// when at level set result[depth] as Max(itself, curNode.val) 

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        
        helper(root, 0, result);
        
        return result;
    }
    
    private void helper(TreeNode node, int depth, List<Integer> result){
        //if null return
        if(node==null)
            return;
        
        //if result.size==depth, add new item to List
        if(result.size()==depth)
            result.add(node.val);
        //else set result[i] to Max(result[i], node.val)
        else
            result.set(depth, Math.max(result.get(depth), node.val));
        //call helper on node.left, node.right with depth+1
        helper(node.left, depth+1, result);
        helper(node.right, depth+1, result);
    }
}