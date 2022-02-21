//Time Complexity: O(n)
//Space COmplexity: O(n)
//Using BFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for(int i = 0; i< size; i++){
                TreeNode curr = q.poll();
                if(curr.val > max) max = curr.val;
                if(curr.left!= null) q.add(curr.left);
                if(curr.right!= null) q.add(curr.right);
                
            }
            result.add(max);
        }
        return result;
    }
}