# Competitive-Coding-5

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 

// Time Complexity : O(n)
// Space Complexity : O(D) (d being the diameter of the tree)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will push the elements of the same level in the queue
2. We will compare the elements of the same element
3. We will add the max value found in the each level to the result list
 
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();

        //using queue to store the elements at the current level

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //run a while loop till my queue is not empty

        while(!queue.isEmpty()){
            //size of the current level
            int len = queue.size();

            int max = Integer.MIN_VALUE;

            for(int i = 0; i<len; i++){
                TreeNode curr = queue.poll();

                if(curr.val > max){
                    max = curr.val;
                }

                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }

            result.add(max);
        }

        return result;
        
    }
}