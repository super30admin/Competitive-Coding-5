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
 // This solution uses DFS approach. At each level, if there is no element we add that element with the index as the level. And we check with existing element and the present to update the maximum. At the end we end up having list of largest in each level
class Solution {
    List<Integer> list = new ArrayList();
    public List<Integer> largestValues(TreeNode root) {
        fetchLargestValue(root, 0);
        return list;
    }

    private void fetchLargestValue(TreeNode root, int level) {
        if(root==null) return;
        if(list.size()==level) {
            list.add(root.val);
        }
        list.set(level, Math.max(list.get(level), root.val));
        fetchLargestValue(root.left, level+1);
        fetchLargestValue(root.right, level+1);
    }
}

