//
// Created by shazm on 8/4/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <set>

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        if(board.empty()){
            return true;
        }
        set<int> segset;
        if(!checkGrid(board,segset)){return false;}
        if(!checkRow(board,segset)){return false;}
        if(!checkColumn(board,segset)){return false;}
        return true;
    }
private:
    bool checkGrid(vector<vector<char>>& board,set<int> segset){
        int i = 0; int j = 0;
        while(i<9){
            for(int x = i; x<i+3; x++){
                for(int y = j; y<j+3; y++){
                    if(board[x][y]!='.' && !segset.insert(board[x][y]).second){
                        return false;
                    }
                }
            }
            segset.clear();
            if(j+3<9){j+=3;}
            else{j = 0; i+=3;}
        }
        return true;
    }

    bool checkRow(vector<vector<char>>& board, set<int> segset){
        int i = 0;
        while(i<9){
            for(int j = 0; j<9; j++){
                if(board[i][j]!='.' && !segset.insert(board[i][j]).second){
                    return false;
                }
            }
            i++; segset.clear();
        }
        return true;
    }

    bool checkColumn(vector<vector<char>>& board, set<int> segset){
        int j = 0;
        while(j<9){
            for(int i = 0; i<9; i++){
                if(board[i][j]!='.' && !segset.insert(board[i][j]).second){
                    return false;
                }
            }
            j++; segset.clear();
        }
        return true;
    }
};