class LargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int maxVal = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                root = q.poll();
                maxVal = Math.max(maxVal, root.val);
                if(root.left!=null){
                    q.add(root.left);
                }
                if(root.right!=null){
                    q.add(root.right);
                }
            }
            result.add(maxVal);
        }
        return result;
    }
}
