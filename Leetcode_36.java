//Travel through the given matrix
//At every element put it in it's respective row set, col set, box set
//If the element is already present - return false
//Else complete iteration
//And return true
//TC: O(9*9)
//SC:3*O(9*9)
class Solution {
    public boolean isValidSudoku(char[][] board) {
       List<HashSet<Integer>> row=new ArrayList<>();
       List<HashSet<Integer>> col=new ArrayList<>();
       List<HashSet<Integer>> box=new ArrayList<>();

       for(int i=0;i<9;i++){
        row.add(new HashSet<>());
        col.add(new HashSet<>());
        box.add(new HashSet<>());
       }

        int m=board.length,n=board[0].length;

        for(int i=0;i<m;i++){
            Set r=row.get(i);
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int curr=board[i][j]-'0';

                if(r.contains(curr)){
                    return false;
                }else{
                    r.add(curr);
                }

                Set<Integer> c=col.get(j);
                if(c.contains(curr)){
                    return false;
                }else{
                    c.add(curr);
                }

                //boxes:
                int req=((i/3)*3)+(j/3);
                Set<Integer> b=box.get(req);
                if(b.contains(curr)){
                    return false;
                }else{
                    b.add(curr);
                }
            }
        }
       return true;
        
    }
}
