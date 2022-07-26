//Time Complexity: O(n)
//Space Complexity: O(n) ; Queue Max Size
//Code run successfully on LeetCode.

public class Problem1_BFS {

    public List<Integer> largestValues(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int max = Integer.MIN_VALUE;
            int size = q.size();
            
            for(int i =0; i < size; i++){
                
                TreeNode curr = q.poll();
                int temp = curr.val;
                max = Math.max(max,temp);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
}
