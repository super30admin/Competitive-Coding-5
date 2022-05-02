//time - O(n)
//space - O(n)
class Solution {
    List<List<Integer>> list;
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        dfs(root, 0);
        int max = Integer.MIN_VALUE;

        for(List<Integer> l : list){
            max = Integer.MIN_VALUE;
            for(Integer e : l){
                max = Math.max(max, e);
            }
            result.add(max);
        }
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root==null) return;
        if(level==list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);

        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
