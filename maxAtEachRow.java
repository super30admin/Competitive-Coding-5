//Time: O(n)
//Space: O(n)

public class maxAtEachRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        //null case
        if (root == null) return result;
        
        //BFS
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                
                TreeNode curr = q.poll();
                //{5, 3, 9}
                //check for max
                System.out.print(curr.val);
                if(curr.val > max) {
                    
                    max = curr.val;
                    
                }
                
                if(curr.left != null) {
                    q.add(curr.left);
                }
                
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(max); //first pass = 1
                                //second pass = [1, ]
        }
        
        return result;
    }
}
