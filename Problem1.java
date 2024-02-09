//Acceptd on LT
//jUST DO Bfs and get max 
//Time should be O(n)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root==null) return l ;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode e = q.poll();
                if(max<e.val){
                    max=e.val;
                }
                if(e.left!=null){
                    q.add(e.left);
                }
                if(e.right!=null){
                    q.add(e.right);
                }

            }
            l.add(max);
        }
        return l;
        
        
    }
}