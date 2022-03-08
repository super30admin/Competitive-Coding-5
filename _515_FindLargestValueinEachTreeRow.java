// Time Complexity : o(n) where n is number of nodes in tree
// Space Complexity : o(d) whre d is diameter of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach : BFS tarversal and get maximum at each level
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();

            int tempMax = Integer.MIN_VALUE;

            for(int i =0 ; i<size; i++){
                TreeNode curr = q.poll();
                tempMax = Math.max(tempMax, curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            res.add(tempMax);

        }

        return res;

    }
}
