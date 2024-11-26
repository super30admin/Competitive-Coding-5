//TimeComplexity O(1) 9*9
//SpaceComplexity O(1) 
//LeetCode tested

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 1; i < 8; i+=3) {
            for (int j = 1; j < 8; j+=3) {
                q.add(new int[]{i,j});
            }
        }
        int dirs[][] = new int[][]{
                {0,1},
                {1,0},
                {0,-1},
                {-1,0},
                {-1,-1},
                {-1,1},
                {1,-1},
                {1,1}
                };
       while (!q.isEmpty()){
           int cur[] = q.poll();
           for (int[]dir:dirs) {
               int r = dir[0]+cur[0];
               int c = dir[1]+cur[1];
               HashSet<Integer> hs = new HashSet<>();
               hs.add(board[cur[0]][cur[1]] - '0');
               if(r>=0 && r< board.length && c>=0 && c<board.length && board[r][c]!='.'){
                   int current_val = board[r][c] - '0';
                   if(!hs.contains(current_val))
                       hs.add(current_val);
                   else return false;
               }
           }
       }
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowCheck = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') continue;
                if(!rowCheck.contains(board[i][j])){
                    rowCheck.add(board[i][j]);
                }else return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> columnCheck = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(i+""+j);
                if(board[j][i] == '.') continue;
                if(!columnCheck.contains(board[j][i])){
                    columnCheck.add(board[j][i]);
                }else return false;
            }
            System.out.println();
        }
       return true;
    }
}
