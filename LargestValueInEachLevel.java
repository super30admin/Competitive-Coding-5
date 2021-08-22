//https://leetcode.com/problems/find-largest-value-in-each-tree-row/

/*
Time: O(n) where n is the number of nodes in the given Binary Tree
Space: O(n) for the Queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

//Idea: We perform a level order traversal using Queues to find the largest element in each level.

public class LargestValueInEachLevel {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);

            }
            result.add(max);
        }

        return result;

    }

}
