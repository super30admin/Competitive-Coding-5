package S30.CompetitiveCoding_5;

/*DFS Solution
Time Complexity : O(NxN)
Space Complexity : O(3XNxN) = O(NxN)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {

    HashMap<String,HashSet<Character>> map;

    public boolean isValidSudoku(char[][] board) {

        int R = board.length;
        if(R == 0) return false;
        int C = board[0].length;
        map = new HashMap<>();

        for(int i = 0; i < R; i ++){
            for(int j = 0; j < C; j ++){
                char value = board[i][j];
                if(value != '.'){
                    if(!checkRow(i,value)) return false;
                    if(!checkCol(j,value)) return false;
                    if(!checksubgrid(i,j,value)) return false;
                }
            }
        }
        return true;
    }

    //O(1)
    public boolean checkRow(int i, char val){

        String key = "r" + i;
        if(!map.containsKey(key)){
            map.put(key,new HashSet<Character>());
        }
        HashSet<Character> set = map.get(key);
        if(set.contains(val)) return false;
        else set.add(val);
        return true;

    }

    //O(1)
    public boolean checkCol(int j, char val){
        String key = "c" + j;
        if(!map.containsKey(key)){
            map.put(key,new HashSet<Character>());
        }
        HashSet<Character> set = map.get(key);
        if(set.contains(val)) return false;
        else set.add(val);
        return true;
    }

    //O(1)
    public boolean checksubgrid(int i, int j, char val){
        int box = (i/3 * 3) + j/3;
        String key = "g" + box;
        if(!map.containsKey(key)){
            map.put(key,new HashSet<Character>());
        }
        HashSet<Character> set = map.get(key);
        if(set.contains(val)) return false;
        else set.add(val);
        return true;
    }
}
