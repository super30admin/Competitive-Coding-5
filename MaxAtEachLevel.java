/*
* Time Complexity: O(n)
    n = nodes
* 
* Space Complexity: O(W) == O(n)
    W = width of tree
* 
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxAtEachLevel {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int level =0;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int index=0; index<size; index++){
                TreeNode curr = queue.poll();

                if(result.size() == level){
                    result.add(curr.val);
                } else {
                    if(result.get(level) < curr.val)
                        result.set(level, curr.val);
                }
                
                if(curr.left!=null)
                    queue.add(curr.left);
                
                if(curr.right!=null)
                    queue.add(curr.right);
            }

            level++;
        }

        return result;
    }
}
