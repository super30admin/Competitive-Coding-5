// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//o(m*n) time and o(n) space
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> check = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(board[i][j] != '.'){

                    // Making a unique key for every element
                    String row = board[i][j] + "in row" + i;
                    String col = board[i][j] + "in col" + j;
                    String box = board[i][j] + "in box" + i/3 + "and" + j/3;

                    if(check.contains(row) || check.contains(col) || check.contains(box)){
                        return false;
                    }

                    check.add(row);
                    check.add(col);
                    check.add(box);
                }
            }
        }
        System.out.println(check);
        return true;


    }
}

// o(m*n) time and o(h) space
class Solution {

    List<Integer> result;

    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;

    }
    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic

        if(result.size() == level){

            result.add(root.val);

        }
        else{
            if(result.get(level) < root.val){
                result.set(level,root.val);
            }
        }
        dfs(root.left, level+1);


        dfs(root.right, level+1);
    }
}

