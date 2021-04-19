import java.util.HashMap;

///Valid sudoku
///tc - O(1)
//sc - O(1)
public class Problem1{
    public static void main(String[] args){
        char[][] input = {{'5','3','.','.','7','.','.','.',"."}
        ,{"6",".",".","1","9","5",".",".","."}
        ,{".","9","8",".",".",".",".","6","."}
        ,{"8",".",".",".","6",".",".",".","3"}
        ,{"4",".",".","8",".","3",".",".","1"}
        ,{"7",".",".",".","2",".",".",".","6"}
        ,{".","6",".",".",".",".","2","8","."}
        ,{".",".",".","4","1","9",".",".","5"}
        ,{".",".",".",".","8",".",".","7","9"}};
        Problem1 p = new Problem1();
        System.out.println(p.isValidSudoku(input));

    }
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] blocks = new HashMap[9];
        
        //initializing the array of maps
        for(int i = 0;i< 9; i++){
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            blocks[i] = new HashMap<>();
        }
        //validate the board by checking freq of each number
        for(int i = 0;i< 9; i++){
            for(int j = 0;j< 9; j++){
                char ch = board[i][j];
                int blockIndex = (i/3)* 3+j/3;
                if(ch != '.'){
                    int num = (ch-'0');
                    rows[i].put(num, rows[i].getOrDefault(num, 0)+1);
                    cols[i].put(num, cols[i].getOrDefault(num, 0)+1);
                    blocks[blockIndex].put(num, cols[i].getOrDefault(num, 0)+1);
                
                    if(rows[i].get(num) >1|| cols[i].get(num)>1 || blocks[i].get(num)>1 ){
                        return false;
                    }
                }
            }
        }
        return true;




    }
}