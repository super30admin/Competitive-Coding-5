//Time Complexity - O(n)
//Space Complexity - O(n)
class Solution {
    List<Integer> maxList;
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        maxList = new ArrayList<>();
        dfs(root, 0);
        return maxList;
    }

    private void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == maxList.size()){
            maxList.add(root.val);
        } else {
            maxList.set(level, Math.max(root.val, maxList.get(level)));
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}