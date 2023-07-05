import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LargestValEachTreeRowBFSIterate {

        //BFS - Iterative - Queue

        public List<Integer> largestValues(TreeNode root) {

            List<Integer> maxInRow = new ArrayList<>();

            if(root == null) return maxInRow;

            Queue<TreeNode> bfsQ = new LinkedList<>();

            bfsQ.add(root);

            //BFS to find the largest value of a tree node in each level

            while(!bfsQ.isEmpty()) {

                int sizeQ = bfsQ.size();

                Integer max = Integer.MIN_VALUE;

                for(int i = 0; i < sizeQ; i++) {

                    TreeNode curr = bfsQ.poll();

                    if(curr.val > max)  max = curr.val;

                    if(curr.left != null) bfsQ.add(curr.left);

                    if(curr.right != null) bfsQ.add(curr.right);
                }
                maxInRow.add(max);
            }
            return maxInRow;
        }


}

/* Time Complexity = O(N) as all tree nodes re traversed in BFS

Space Complexity = O(N)

complete binary tree has n/2 leaves in the last level = O(D) = O(N/2) = O(N)
D = diameter of binary tree = maximum size of queue
*/
