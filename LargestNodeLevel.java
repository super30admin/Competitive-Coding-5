public class LargestNodeLevel {

    // Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
We use level order traversal to solve the problem
*/

 public List<Integer> largestValues(TreeNode root) {
     List<Integer> output = new ArrayList<>();
     if(root == null)
        return output;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        int size = queue.size();
        int max = Integer.MIN_VALUE;
        for(int i =0; i < size; i++){
            TreeNode node = queue.remove();
            if(node.val >= max){
                max = node.val;
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        output.add(max);
    }
    return output;       
    } 
}

