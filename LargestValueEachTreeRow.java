class LargestValueEachTreeRow{

    // BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                max = Math.max(max, cur.val);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            result.add(max);
        }
        return result;
    }

    // DFS
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        // base
        if(root == null) return;


        // logic
        if(result.size() == level){
            result.add(root.val);
        } else{
            int prev = result.get(level);
            int max = Math.max(prev, root.val);
            result.set(level, max);
        }
        dfs(root.left, level +1);
        dfs(root.right, level +1);
    }
}