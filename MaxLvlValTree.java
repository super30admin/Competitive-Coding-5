/**
// Time Complexity : O(n)
// Space Complexity : O(h) h = height of Tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//nope

// Your code here along with comments explaining your approach
// do preorder traversal while maintaining level.
//level directly is associated with indx
//of max val at each tree lvl in ret list.
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>(); //[1, 3, 5, ]
        dfsHelper(root, ret, 0);
        return ret;
    }

    private void dfsHelper(TreeNode node, List<Integer> ret, int lvl){//9, 2
        if(node == null)
            return;

        //preorder trav.
        if(ret.size() == lvl){ //lvl not seen
            ret.add(node.val);
        }
        else{ //if lvl already seen.
            int max = Math.max(ret.get(lvl), node.val);
            ret.set(lvl, max);
        }

        dfsHelper(node.left, ret, lvl+1);
        dfsHelper(node.right, ret, lvl+1);
    }
}
