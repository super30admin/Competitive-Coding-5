// https://leetcode.com/problems/find-largest-value-in-each-tree-row/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> l= new ArrayList<>();
        if(root==null)
            return l;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int max=Integer.MIN_VALUE;
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode curr=q.poll();
                max=Math.max(max,curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            l.add(max);
        }  
        return l;      
    }
}





//https://leetcode.com/problems/valid-sudoku/description/
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


class Solution{
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(Character.isDigit(board[i][j]))
                {
                    if(!set.add(board[i][j]+" row: " + i ) || !set.add(board[i][j]+" col: " + j)|| !set.add(board[i][j]+" rowcol: " + i/3+"," +j/3 ) )
                        return false;
                }
            }
        }
        return true;
    }
}
