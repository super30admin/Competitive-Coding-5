//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    List<Integer> result;
    int depth = 0;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) {
            return new ArrayList<>();
        }
        dfs(root, depth);
        return result;
     
    }
    
    public void dfs(TreeNode root, int depth) {
        //base
        if(root == null) {
            return;
        }
        
        
        if(result.size() == depth) {
            result.add(root.val);
        }
        
        if(root.val > result.get(depth)) {
            int x = root.val;
            result.set(depth, x);
        }
        
        //logic
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}