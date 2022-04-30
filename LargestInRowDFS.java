import java.util.ArrayList;
import java.util.List;

public class LargestInRowDFS {

    // DFS approach
    // TC: O(n) n - number of nodes in a tree
    // SC: O(h) height of the tree
    List<List<Integer>> levelElements;
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        levelElements = new ArrayList<>();
        dfs(root, 0);

        for(List<Integer> elements : levelElements) {
            findMaxInLevel(elements, result);
        }
        return result;
    }

    private void findMaxInLevel(List<Integer> elements, List<Integer> result) {
        int max = Integer.MIN_VALUE;
        for(int element : elements) {
            max = Math.max(max, element);
        }
        result.add(max);
    }

    private void dfs(TreeNode root, int level) {
        // base condition
        if(root == null) return;

        if(level == levelElements.size()) levelElements.add(new ArrayList<>());

        levelElements.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);

    }
}
