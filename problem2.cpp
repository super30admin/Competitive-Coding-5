/*
// Time Complexity : O(M*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
iterating through block was challenging.


// Your code here along with comments explaining your approach
Go through matrix row by row and check the number , if already exist then return false in the row else make true
Go through matrix column by column, if already exist then return false in the column else make that int true
Go through block by block , if the num already exist then return false block else make that int true

*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {

        int m = board.size();
        int n = board.at(0).size();

        if(m!=9 && n!=9) return false;

        //row
        for(int i{};i<m;++i){
            vector<bool> hash_set(m,false);
            for(int j{};j<n;++j){
                char val = board.at(i).at(j);
                if(val!='.'){
                    int idx = val - '0'-1;
                    //cout<<idx<<" ";
                    if(hash_set[idx] == true) return false;
                    hash_set[idx] = true;
                }
            }
        }

        //cout<<"done"<<endl;

        //col
        for(int i{};i<n;++i){
            vector<bool> hash_set(m,false);
            for(int j{};j<m;++j){
                char val = board.at(j).at(i);
                if(val!='.'){
                    int idx = static_cast<int>(val) - 49;
                    cout<<idx<<" ";
                    if(hash_set[idx] == true) return false;
                    hash_set[idx] = true;
                }
            }
        }

        //cout<<"done"<<endl;

        //matrix squares
        for(int i{};i<m;++i){
            vector<bool> hash_set(m,false);
            for(int j{};j<n;++j){
                int x = 3*(i/3)+j/3;
                int y = 3*(i%3)+j%3;
                char val = board.at(x).at(y);
                if(val!='.'){
                    int idx = static_cast<int>(val) - 49;
                    if(hash_set[idx] == true) return false;
                    hash_set[idx] = true;
                }
            }
        }
        //cout<<"done"<<endl;
        return true;
    }
};