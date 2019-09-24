//Time complexity:O(N) where N is the number of nodes.
//Space complexity:O(N)
//In this problem, I will be using BFS algorithm to find the largest element in each tree row as BFS will help me traverse the tree level by level. I'll also have a queue to maintain elements at each level and a temp variable large to hold the largest element at each level at that instant. I'll do the level order traversal and then I'll maintain the largest element at that instant in the temp variable large. At the end of each iteration, I'll be appending the large value to my result list. 
//This code was executed successfully and got accepted in leetcode. 
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size=queue.size();
           // TreeNode node=queue.poll();
            int large=Integer.MIN_VALUE;
           while(size>0){
            TreeNode node = queue.poll();
            large=Math.max(large,node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
             size--;  
            }
            res.add(large);
           
            
        }
        return res;
    }
}