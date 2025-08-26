// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Largestvalue {
    // Use BFS to traverse row by row and calculate max on each row.
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int size = 0;
        int max ;
        TreeNode tempnode;
        while(!que.isEmpty())
        {
            max = Integer.MIN_VALUE;
            size = que.size();
            for(int i=0;i<size;i++)
            {
                tempnode = que.poll();
                max = Math.max(tempnode.val,max);
                if(tempnode.left!=null){
                que.add(tempnode.left);
                }
                if(tempnode.right!=null){
                que.add(tempnode.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}