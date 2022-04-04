//TimeComplexity O(n)
//SpaceComplexity O(n)
//LeetCode tested

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        //result.add(root.val);
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode current = queue.poll();
                if(max<current.val){
                    max=current.val;
                }
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
