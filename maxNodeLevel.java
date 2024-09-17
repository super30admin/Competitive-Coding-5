//TC - O(n) as we go through all the tree nodes
//sc - O(n) max number of elements as children
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: simple BFS, keep track of level by using size of Q.
// second solution is DFS, which is worse space complexity wise.

public class maxNodeLevel {
    List<Integer> res;

    //BFS
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        //base
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();

            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode n = q.poll();
                max = Math.max(max, n.val);
                if(n.left != null)
                    q.add(n.left);
                if(n.right != null)
                    q.add(n.right);
            }
            res.add(max);
        }
        return res;
    }

    //DFS
    class Solution {
        List<Integer> res = new ArrayList<>();
        public List<Integer> largestValues(TreeNode root) {

            if(root == null) return res;
            dfs(root, 0);
            return res;
        }
        private void dfs(TreeNode root, int lvl){
            if(root == null) return;

            if(res.size() == lvl)
                res.add(root.val);
            else{
                res.set(lvl, Math.max(root.val, res.get(lvl)));
            }
            dfs(root.left, lvl+1);
            dfs(root.right, lvl+1);
        }
    }
}
