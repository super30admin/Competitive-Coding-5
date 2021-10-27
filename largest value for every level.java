// Time Complexity : O(N)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : took lot of time to correct errors.
// Your code here along with comments explaining your approach:- recursively using bfs and adding values to list . it will
// be changed when outputlist size is grater than h at h position.


class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        int h=0;
        levelorderlargest(root,h);
        
        
    return result;}
    private void levelorderlargest(TreeNode root,int h){
        if(root==null){
            return;
        }
        if(h==result.size()){
            result.add(root.val);
        }
        else if(h<result.size()){
            if(result.get(h)<root.val){
                result.set(h,root.val);
            }
            
        }
        levelorderlargest(root.left,h+1);
        levelorderlargest(root.right,h+1);
    }
}