// Time Complexity : O(N) where N is the number of all tree nodes
// Space Complexity : O(N) asymptotically else it will be number of leaf nodes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Applied BFS and maintained a max variable and updated it when any element is
// greater than that element in that row.

class Solution {
    public List<Integer> largestValues(TreeNode root) {


        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int max;

        while(!q.isEmpty()){

            max = Integer.MIN_VALUE;

            int size = q.size();

            for(int i = 0; i < size; i++){

                TreeNode curr = q.poll();

                if(max < curr.val){
                    max = curr.val;
                }

                if(curr.left != null){
                    q.add(curr.left);
                }

                 if(curr.right != null){
                  q.add(curr.right);
                }
            }

            result.add(max);

        }

        return result;

    }
}
