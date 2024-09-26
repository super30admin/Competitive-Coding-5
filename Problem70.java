Executed in leet code-Yes
Time complexity-o(n)
space complexity-o(n)
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        //base case
        if(root==null) return result;

        // logic
        dfs(root,result,0);
        result.remove(result.size()-1);
        result.remove(result.size()-1);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> result,int level){
        if(result.size() <=level+1)
          result.add(level,Integer.MIN_VALUE);

        if(root==null) return;
        if(root.val>result.get(level))
            result.set(level,root.val);
         dfs(root.left,result,level+1);
         dfs(root.right,result,level+1);
    }
}
