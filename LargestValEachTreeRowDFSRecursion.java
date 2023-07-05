import java.util.List;
import java.util.ArrayList;

public class LargestValEachTreeRowDFSRecursion {

        public List<Integer> largestValues(TreeNode root) {

            // DFS - Recursion

            List<Integer> maxInRow = new ArrayList<>();

            recurse(root, maxInRow, 0);

            return maxInRow;
        }

        public void recurse(TreeNode root, List<Integer> maxInRow, int level) {

            //null case
            if (root == null) return;

            // if root is the first in that level, add it to result tentatively
            if (maxInRow.size() == level) {

                maxInRow.add(root.val);
            }

            // update the maximum in a level
            /*else if(root.val > maxInRow.get(level)) {

            maxInRow.set(level, root.val);
            }*/
            maxInRow.set(level, root.val > maxInRow.get(level) ? root.val : maxInRow.get(level));

            // recursively call left child of next level
            recurse(root.left, maxInRow, level + 1);

            // recursively call right child of next level
            recurse(root.right, maxInRow, level + 1);

        }

}

/* Time Complexity = O(N) - traverses all nodes
Space Complexity = O(N) - recursive stack of DFS */