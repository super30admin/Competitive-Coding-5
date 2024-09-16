/*SC, TC  - O(N)
 * */



// BFS
class Solution {
    
    public List<Integer> largestValues(TreeNode root) {
        // DFS 
         List<Integer> result = new ArrayList<>();
        if(root == null) return result;
       
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int largest = Integer.MIN_VALUE;
            int size  = queue.size();
            for(int i = 0 ; i < size; i++){
                TreeNode elem = queue.poll();
                 largest  = Math.max(largest, elem.val);
                    
                
               
                if (elem.left != null){
                    queue.add(elem.left);
                }
                if (elem.right!= null){
                    queue.add(elem.right);
                }
            }
            result.add(largest);
            level +=1;
            
        }
     return result;
        
    }  
    
}
// DFS

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        // DFS 
        if(root == null) return result;
        dfs(root, 0);
        return result;
        
    }
    
    public void dfs(TreeNode node, int size){
        
        // base 
        if (node == null) return ;
        // logic
        if (result.size() == size){
            result.add(node.val);
        } else{
            result.set(size, Math.max(result.get(size), node.val));
        }
        
        dfs(node.left, size + 1);
        dfs(node.right, size +1 );
    }
    
}
