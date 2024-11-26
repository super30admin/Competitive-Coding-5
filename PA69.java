//Leetcode 515. Find Largest Value in Each Tree Row
//Time Complexity: O(n)
//Space Complexity: O(n) // n is the height of the tree
//DFS solution
class Solution {
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {      
        res= new ArrayList<>();
        if(root==null){
            return res;
        }
        dfs(root,0);
        return res;
    }
    
    
    private void dfs(TreeNode root, int level){
        if(root==null) return ;
        if(res.size()==level) res.add(root.val);
        if(res.size()>level) {
            if(res.get(level) < root.val) res.set(level,root.val);
        }
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        return;
        
    }
}

=========================================

BFS solution:

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if(root==null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        res.add(root.val);
        int m;
        int size;
   
        while(!q.isEmpty()){
           size = q.size();
            m=Integer.MIN_VALUE;
            boolean f=false;
            for(int i=0;i<size;i++){
               TreeNode n= q.poll();
                if(n.left!=null) {
                    f=true;
                    if(m<=n.left.val){
                        m=n.left.val;
                    }
                    q.offer(n.left);
                }
                if(n.right!=null) {
                    f=true;
                    if(m<=n.right.val){
                        m=n.right.val;
                    }
                    q.offer(n.right);
                }
                
            }
            if(f){
                res.add(m);
            }
            
            
        }
        return res;
    }
}

==============================================
