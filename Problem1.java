//515. Find Largest Value in Each Tree Row
//Time Complexity :  O(n)
//Space Complexity:  O(n)

//Approach : 
// 1. Use the BFS approach as the problem states go through level by level (row)
// 2. Find Max in each row and insert it in the resultant array.
// 3. Traverse the entire tree and return result.

// Run on Leet code : Yes.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null) return result; //base case

        Queue<TreeNode> q = new LinkedList();

        // we will add the root to queue
        q.add(root);
        
        while(!q.isEmpty()){
            
            int maxCount = Integer.MIN_VALUE;
            
            int noofLevels = q.size();
            
            
            for(int i=0;i<noofLevels;i++){
                //storeing the Max Count Value;
                 TreeNode node = q.remove();

                if(node.val > maxCount ){
                    maxCount = node.val;
                }
                
                if(node.left!= null){
                    q.add(node.left);
                }
                if(node.right!= null){
                    q.add(node.right);
                }
            }
            result.add(maxCount);
            
        }
        
        return result;
        
        
    }
}
