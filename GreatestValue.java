// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes  
// Any problem you faced while coding this: No
//approach:
//1. create a queue to store the nodes
//2. add the root to the queue
//3. while the queue is not empty, get the size of the queue
//4. get the maximum value in the queue
//5. add the maximum value to the result
//6. return the result  
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int Max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                Max=Math.max(Max,node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            result.add(Max);
        }
        return result;

        
    }
}