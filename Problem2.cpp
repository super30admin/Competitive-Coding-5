// Problem Name: Valid Sudoku
//  Time Complexity : O(9x9)
//  Space Complexity : O(3 * 81) ~ O(1) constant space
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first have three unordered_maps declared one for rows, one for cols and
// one for boxes
// 2. We then check if a particular row or particular col or particular box
// contain a repeated value using set's O(1) lookup, if yes we immediately
// return false
// 3. Othwerwise, if we reach the loop end we return true

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  bool isValidSudoku(vector<vector<char>> &board) {
    unordered_map<int, unordered_set<int>> rows;
    unordered_map<int, unordered_set<int>> cols;
    unordered_map<int, unordered_set<int>> boxes;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char el = board[i][j];
        int boxIndex = (i / 3) * 3 + j / 3;
        if (el == '.')
          continue;
        if (rows[i].count(el) || cols[j].count(el) ||
            boxes[boxIndex].count(el)) {
          return false;
        }
        rows[i].insert(el);
        cols[j].insert(el);
        boxes[boxIndex].insert(el);
      }
    }
    return true;
  }
};
