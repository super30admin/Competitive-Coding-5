bfs 
// level of the tree
// queue 
// 3,2 -> result
// 5,3,9 -> result 

dfs
// 1 -> 0
// 2,3 -> 1

/TC: O(n)
/SC: O(h)

 */
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        this.result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level)
    {
        if(root == null) return;

        //logic
        if(result.size()==level)
        {
            result.add(root.val);
        }
        else if(result.get(level) != null && result.get(level) < root.val)
        {
            result.set(level, root.val);
        }

        //recursion
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}