//Time Complexity:O(n)
//Space complexity:O(h)

class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result=new ArrayList();
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level==result.size()){
            result.add(root.val);
        }
        if(root.val>result.get(level)){
            result.set(level,root.val);
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}