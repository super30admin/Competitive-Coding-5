// Time Complexity : O(n)-> where n is number of nodes in Binary tree
// Space Complexity : O(log n)-> height of the complete Binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was sure about BFS. But DFS made me confuse on level by level comparisons.]
/* Your code here along with comments explaining your approach: Do a DFS, add the  nodes seen till you reach the leaf, to the output array. While 
the DFS is taking place, maintain the level information. When the node value at a certain level needs to be compared, it can access the output array
index and compare with the value and store the maximum of them.
*/

// DFS
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        int level = 0;
        result = new ArrayList<>();
        if(root == null){return result;}                        // Base Case
        maxTree(root, 0);
        return result;
    }
    private void maxTree(TreeNode root, int level){
        if(root == null){return;}
        if(result.size() > level){                                          // If result size is > level => I have values filled to fetch out for comparison with the current root value
            if(result.get(level)<= root.val)
                {result.set(level, root.val);                               // update the result index
                }
        }
        else 
        {result.add(root.val);}                                             // Add to the result if nothing is there
        
        maxTree(root.left, level+1);                                        // Recursive DFS
        maxTree(root.right, level+1);
    }
}

// BFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) { return result; }
    Queue<TreeNode> q = new LinkedList<>();                                     // Queue for BFS
    q.add(root);
    while(!q.isEmpty()){
    int size = q.size();                                                        // level by level comparisons
    int max = Integer.MIN_VALUE;                                    
    for(int i = 0; i < size; i++){  
        TreeNode value = q.poll();
        max = Math.max(max, value.val);                                         // Max value after comparisons with the current value
        if(value.left != null){q.add(value.left);}
        if(value.right != null){q.add(value.right);}
    }
        result.add(max);                                                        // Add the max at the current level to the result
    }
        return result;
    }
}