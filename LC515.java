class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> output = new ArrayList<>();
        recurr(root, output, 0);
        return output;
    }
    
    public void recurr(TreeNode root, List<Integer> output, int level){
        if(root == null){
            return;
        }
        
        if(level == output.size()){
            output.add(root.val);
        } else{
            output.set(level, Math.max(output.get(level), root.val));
        }
        
        recurr(root.left, output, level + 1);
        recurr(root.right, output, level + 1);
    }
}

//Time Complexity:O(n)
//Space complexity:O(h)