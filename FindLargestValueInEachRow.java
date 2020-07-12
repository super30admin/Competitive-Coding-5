// Time Complexity : O(n), no. of nodes in tree
// Space Complexity : O(n/2) = O(n) (no. of leaf nodes in tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Solution : Iterative 
//Level order traversal (BFS)
//In each level find max value
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        //create result list
        List<Integer> result = new ArrayList<>(); 
        //check if tree empty, if empty return result
        if(root == null) return result; 
        //create queue for level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        //add root to queue
        q.add(root);
        
        //do while queue is not empty
        while(!q.isEmpty()){
            //keep size count (to get max for each level)
            int size = q.size();
            //set max to minvalue
            int max = Integer.MIN_VALUE;
            //loop till size > 0 (level size)
            while(size > 0) {
                //pop the front of queue
                TreeNode curr = q.poll();
                //decrease the size value
                size--;
                //compare value with max, if max is < than curr.val
                //make max = curr.val
                if(max < curr.val) {
                    max = curr.val;
                }
                //if curr nodes has children add to queue 
                if(curr.left!= null) q.add(curr.left);
                if(curr.right!= null) q.add(curr.right); 
            } result.add(max); //end of each level add the max to the result
        } return result; //when queue is empty return reult list      
    }
}

/////////////////////


// Time Complexity : O(n), no. of nodes in tree
// Space Complexity : O(h) height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Solution : Recursive 
//DFS
//In each level find max value
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        //create result list
        result = new ArrayList<>(); 
        //check if tree empty, if empty return result
        if(root == null) return result;
        //call dfs with curr root and level (tree root is at level 0)
        levelorderdfs(root, 0);
        //return the result list
        return result;
    }
    
    private void levelorderdfs(TreeNode root, int level) {
        //if root == null, return 
        if(root == null) return;
        
        //we add elements as we visit the node while dfs 
        //if the level and size of result is equal
        //add the cur root value to the result list (adds to that index position)
        if(result.size() == level){
            result.add(root.val);
        }
        //else, result already has that levels, some value
        //get that positions value and compare with curr roots value is less
        //set that positions value to the currroot value
        else if(result.get(level) < root.val) {
            result.set(level,root.val);
        }       
        //call dfs method on left child, level incs by 1
        levelorderdfs(root.left, level+1);
        //call dfs method on right child, level incs by 1
        levelorderdfs(root.right, level+1);    
    }    
}
