// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YEs
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if(root==null)
            return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root==null) return;
        if(result.size()==level)
            result.add(root.val);
        else
            result.set(level,Math.max(result.get(level),root.val));
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                max = Math.max(curr.val,max);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
}