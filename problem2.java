//time :O(N)
//space :O(H)
class Solution {

    public List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        recur(root, 0);
        return res;
    }

    void recur(TreeNode root, int level) {

        if (root == null)
            return;

        if (level == res.size())
            res.add(Integer.MIN_VALUE);

        int max = Math.max(res.get(level), root.val);
        res.set(level, max);

        recur(root.left, level + 1);
        recur(root.right, level + 1);
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode dummy = q.remove();
                if (dummy.val > max) {
                    max = dummy.val;
                }

                if (dummy.left != null) {
                    q.add(dummy.left);
                }
                if (dummy.right != null) {
                    q.add(dummy.right);
                }
            }

            result.add(max);

        }
        return result;
    }
}