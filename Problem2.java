// Time - O(N)
// Space - O(N)


class Solution {
    public List<Integer> largestValues(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<Integer>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();

            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if(max < curr.val) {

                    max = curr.val;

                }

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);

            }

            result.add(max);

        }

        return result;


    }
}