// Time Complexity : O(N)
// Space Complexity : O(h) 

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        while (!q.isEmpty()) {
            int size = q.size();
            int tempMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if (curr.val > tempMax) {
                    tempMax = curr.val;
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
             result.add(tempMax);
        }

        return result;
    }
}