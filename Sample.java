//Problem 1: Valid Sudoku
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes


// Your code here along with comments explaining your approach
// Approach-> keep a String set which contains row ith and num as a string, similar for column and cube-> now if anything is repeated, return false because same number cannot be repeated in same row, col, grid.
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set=new HashSet<>();
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                char ch=board[i][j];
                if(ch!='.'){
                    if(!set.add("row"+i+ch) || !set.add("col"+j+ch) || !set.add("cube"+(i/3)+(j/3)+ch))
                        return false;
                }
            }
        return true;
    }
}


//Problem 2: Largest number of every row in BT
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
// BFS-> keep a max element for each level in BT and update max variable of that level every time u add a node in that level, at the end store that max in resultant list.
class Solution {
    //bfs
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        this.res=new ArrayList<>();
        if(root==null) return res;
        // Queue<TreeNode> q=new LinkedList<>();
        // q.add(root);
        // while(!q.isEmpty()){
        //     int size= q.size(); //o(1)
        //     int max=Integer.MIN_VALUE;
        //     while(size-- >0){
        //         TreeNode cur=q.poll();
        //         max= Math.max(max, cur.val);
        //         if(cur.left!=null) q.add(cur.left);
        //         if(cur.right!=null) q.add(cur.right);
        //     }
        //     res.add(max);
        // }
        // return res;

        dfs(root, 1);
        return res; 
    }
    private void dfs(TreeNode root, int height){
        //base
        if(root==null) return;

        if(height>res.size())
            res.add(root.val);
        else
            res.set(height-1, Math.max(res.get(height-1), root.val));

        dfs(root.left, height+1);
        dfs(root.right, height+1);
    }
}