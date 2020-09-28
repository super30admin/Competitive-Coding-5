    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/find-largest-value-in-each-tree-row/
    Time Complexity for operators : o(n) .. number of nodes in tree.
    Extra Space Complexity for operators : o(n) ... used queue for BFS(level order). Recursive stack for DFS
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach: Explianing by considering BFS(level order) and DFS both.
                              
            BFS(level order) approach   
                    A. Add the root element inot the queue.
                    B. in while loop, take the size of queue and iterate thru the for loop.
                    C. in the for loop, check the max value in the queue. Also, move left and right if it persists.
                    D. after for loop, add that max value into the resulting list.
                    F. In the end, return list after while loop.

            DFS approach   
                    A. We will make recursive call to the dfs() function by passing treenode, rownum and the list.
                    B. in dfs() function, if root == null then return
                    C. We will check if the size of list is equal to the row number if it is then add element to the list()
                    D. If it is not then one of the node is alrwady added on that level. Then check the value of that
                       rownum from list with the current node of tree. whichever is max replace that to the list(roenum)
                    E. After that make recursive calls to left and right side.
                    F. return list from the main function.

       */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        
        // by using BFS
//         Queue<TreeNode> queue = new LinkedList<>();
//         List<Integer> list = new ArrayList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             int max = Integer.MIN_VALUE;
//             for(int i=0;i<size;i++){
//                 TreeNode front = queue.poll();
                
//                 if(front.val > max)
//                     max = front.val;
                
//                 if(front.left!=null)
//                     queue.add(front.left);
                
//                 if(front.right!=null)
//                     queue.add(front.right);
//             }
            
//             list.add(max);
//         }

        List<Integer> list = new ArrayList<>();
        
        dfs(root,0,list);
        
        return list;
    }
    
    // by using DFS
    private void dfs(TreeNode root, int rowNum, List<Integer> list){
        
        
        if(root==null)
            return;
        
        if(list.size() == rowNum){
            list.add(root.val);
        }else{
            int max = Math.max(root.val,list.get(rowNum));
            list.set(rowNum,max);
        }
        
        dfs(root.left,rowNum+1,list);
        dfs(root.right,rowNum+1,list);
    }
}