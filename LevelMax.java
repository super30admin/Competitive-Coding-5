// Time Complexity : O(n) n no.of nodes
// Space Complexity : O(l) levels of tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
used level orser traversal and stored nodes in each level into a list and found the max in each list.
this max at each level is addede to the result list and this is returned.



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   List<Integer> result = new ArrayList<>();
   HashMap<Integer,List<Integer>>map = new HashMap<>();
    public List<Integer> largestValues(TreeNode root) {
        helper(root,0);
        int level = 0;
        while(map.containsKey(level)){
            List<Integer>li = map.get(level);
            result.add(maxi(li));
            level++;
        }
        return result;
    }
     private void helper(TreeNode root, int level){
        //base
        if(root == null) return;
        
        //logic
        if(!map.containsKey(level)){
            map.put(level,new ArrayList<>());
        }
        map.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
    private int maxi(List<Integer>li){
        int max = li.get(0);
        for(int i=1;i<li.size();i++){
            if(li.get(i)>max) max = li.get(i);
        }
        return max;

    }
}
