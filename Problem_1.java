// Time complexity - O(n)
// Space complexity - O(2^h), h = height of tree

// Level order traversal with max variable

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = q.poll();
                max = Math.max(max,tmp.val);
                if(tmp.left != null) q.add(tmp.left);
                if(tmp.right != null) q.add(tmp.right);
            }
            result.add(max);
        }
        return result;
    }
}
