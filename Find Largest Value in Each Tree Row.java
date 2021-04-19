//Time Complexity : O(N) as all the nodes in the tree are visited
//Space Complexity : O(N). recursive stack occupies O(N) space
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return result;
        }
        //helper function to perform dfs
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        //at each level determine the max value
        int max = Integer.MIN_VALUE;
        //check the level
        if(result.size() == level){
            //if the current node's value is larger than the max value then change the max
            if(max <= root.val){
                result.add(root.val);
            }
        }
        //if teh level is same check the value of the node on the other side of the tree and if max , update it in the result
        else{
            if(result.get(level)<root.val){
                result.set(level,root.val);
            }
        }
        //continue the traversal in the left and right subtree
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}