// Time = O(n)
// Size = O(n)
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return res;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        findLargest(q1);
        return res;
    }
    private int findLargest(Queue<TreeNode> q1){
        if(q1==null || q1.isEmpty()) return 0;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> q2 = new LinkedList<>();
        // int size
        // one q = q1
        
        while(!q1.isEmpty()){ //size!=0
            TreeNode root = q1.poll();
            if(root.val>max) max=root.val;
            if(root.left != null) q2.add(root.left); size++
        if(root.right != null) q2.add(root.right);size++
        }
        res.add(max);
        findLargest(q2);
        return 0;
    }
}
