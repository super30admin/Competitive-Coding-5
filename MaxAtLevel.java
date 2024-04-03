/* DFS
TC: O(N)
SC: O(N)
*/
class MatAtLevel {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root == null ) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null ) return;
        if(level == result.size()){
                result.add(root.val);
        }
        else if (root.val >= result.get(level)){
            result.set(level,root.val);
        }
        System.out.println(result);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

/* BFS
TC: O(N)
SC: O(N)
*/
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return result;
        q.add(root); // 3, 2
        //int level = 0;
        while(!q.isEmpty()){
            int size = q.size(); //2
            int max = Integer.MIN_VALUE;
            for( int i =0 ;i < size ; i++){
                TreeNode curr = q.poll();
                max = Math.max(max , curr.val); //3
                if(curr.left!=null){
                    q.add(curr.left); 
                }
                if(curr.right != null){
                    q.add(curr.right);
                }  
            }
            result.add(max); //res: [1,2]       
        }
        return result;    
    }
}