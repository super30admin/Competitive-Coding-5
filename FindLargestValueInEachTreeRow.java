// BFS solution

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int max_val = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                max_val = Math.max(max_val, curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            res.add(max_val);
        }
        return res;  
    }
}

// DFS solution

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        this.res = new ArrayList<>();
        if(root == null)
            return res;
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root == null)
            return;
        
        //logic
        if(res.size() == level)
            res.add(root.val);
        else{
            int n = res.get(level);
            int max = Math.max(n, root.val);
            res.set(level, max);
        }
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
