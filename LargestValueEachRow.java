// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
BFS and find max at each level, at end of level add max to result
*/
public class LargestValueEachRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        if(root== null) return result;

        Queue<TreeNode> queue= new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int qs= queue.size();
            int max= Integer.MIN_VALUE;
            for(int i=0;i<qs;i++){
                TreeNode curr= queue.poll();
                max=Math.max(curr.val,max);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            result.add(max);
        }

        return result;
    }
}
