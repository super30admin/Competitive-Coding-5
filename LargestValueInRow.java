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
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode curr = q.poll();
                System.out.println(curr.val+" curr "+max);
                if(max<curr.val)
                    max = curr.val;
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
            System.out.println();
            res.add(max);
        }
        return res;
    }
}


//Time complexity : O(N) where N is the number of elements in tree
//Space complexity : O(n) where n is the number of nodes in a level
