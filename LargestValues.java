import java.util.List;
import java.util.Queue;

/*
 * Problem 1: https://leetcode.com/problems/find-largest-value-in-each-tree-row/

Time Complexity :   O (N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (515. Find Largest Value in Each Tree Row)
Any problem you faced while coding this :       No

 */
// Input: root = [1,3,2,5,3,null,9]
// Output: [1,3,9]

public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // null check
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            
            for(int i=0; i< size; i++){
                TreeNode currNode = q.poll();
                max = Math.max(max, currNode.val);
                
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
