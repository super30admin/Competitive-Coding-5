// Time Complexity :O(N)
// Space Complexity :O(w) width of the tree if balanced binary tree then it O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class FindLargestInEachRow {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null){ // happy case
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){

                TreeNode current = queue.poll();

                if(current.val > max){
                    max = current.val;
                }

                if(current.left != null){
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
