// Time - O(N)
// Space - O(N)
// BFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++) {
                TreeNode ele = q.poll();
                max = Math.max(max, ele.val);
                if(ele.left!=null) {
                    q.add(ele.left);
                }
                if(ele.right!=null) {
                    q.add(ele.right);
                }
            }
            result.add(max);
        }
        
        return result;
        
    }
}
// DFS
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        
        if(root == null) {
            return new ArrayList<>();
        }
        
        dfs(root, 0);
        
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        
        if(root == null) {
            return;
        }
        
        if(level == result.size()) {
            result.add(root.val);            
        }
        else {
            int cur = result.get(level);
            if(cur < root.val) {
                result.set(level, root.val);
            }
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
