// Time Complexity : O(n)
// Space Complexity : O(2^h), h = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Goto each level of the tree using BFS and calculate the max value at each level

public class FindLargestValueInEachTreeRow {

    // Solution 1 : BFS 
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            int max = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                
                if(i == 0)
                    max = curr.val;
                else{
                    max = Math.max(curr.val, max);
                }
                
                if(i == size - 1){
                   result.add(max);
                } 
                
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        return result;
    }

    // Solution 2 : DFS 
    // List<Integer> result = new ArrayList<>();
    // public List<Integer> largestValues(TreeNode root) {
    //     if(root == null) return result;
        
    //     dfs(root, 0);
    //     return result;
    // }
    
    // private void dfs(TreeNode root , int height){
    //     if(root == null) return;
        
    //     if(result.size() <= height){ 
    //         result.add(root.val);
    //     } else {
    //         result.set(height, Math.max(root.val, result.get(height) ));
    //     }

    //     dfs(root.left, height + 1);
    //     dfs(root.right, height + 1);
    // }
}
