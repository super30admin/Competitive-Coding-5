import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Problem: Find Largest Value in Each Tree Row (LeetCode 515)

Approach 1: BFS (Level Order Traversal)
Time:  O(n)  -> each node processed once
Space: O(w)  -> queue holds up to max width of the tree

Approach 2: DFS (Preorder with level tracking)
Time:  O(n)  -> each node processed once
Space: O(h)  -> recursion stack up to tree height (worst-case O(n) for skewed tree)
*/
public class GreatestValueInEachRow {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelMax = Math.max(levelMax, node.val);// track max for this level
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // after finishing the entire level
            res.add(levelMax);
        }
        return res;
    }
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsHelper(root,0,res);
        return res;
    }
    private void dfsHelper(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        // first node seen at this level -> add it
        if(level == res.size()) {
            res.add(root.val);
        }
        else {
            // update max at this level
            res.set(level, Math.max(res.get(level), root.val));
        }
        dfsHelper(root.left, level + 1, res);
        dfsHelper(root.right, level + 1, res);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        GreatestValueInEachRow sol = new GreatestValueInEachRow();

        List<Integer> ansBFS = sol.largestValues(root);
        System.out.println("BFS result  : " + ansBFS);

        List<Integer> ansDFS = sol.largestValues2(root);
        System.out.println("DFS result  : " + ansDFS);

        // Simple pass/fail checks
        System.out.println("BFS correct? " + ansBFS.equals(List.of(1, 3, 9)));
        System.out.println("DFS correct? " + ansDFS.equals(List.of(1, 3, 9)));
    }
}
