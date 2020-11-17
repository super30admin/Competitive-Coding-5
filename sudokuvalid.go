// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
for each row if flag already present return false else mark flag for that number as true
for each column if flag already present return false else mark flag for that number as true
for each block set row and column start indexes and if flag already present return false else mark flag for that number as true
*/
package main

import "fmt"

func isValidSudoku(board [][]byte) bool {
	if len(board) == 0 || len(board[0]) == 0 {
		return false
	}
	for i:=0;i<len(board);i++ {
		flag := make([]bool, 9)
		for j:=0;j<len(board[0]);j++ {
			if board[i][j] != '.' {
				if flag[board[i][j] - '1'] {
					return false
				} else {
					flag[board[i][j] - '1'] = true
				}
			}
		}
	}
	for i:=0;i<len(board);i++ {
		flag := make([]bool, 9)
		for j:=0;j<len(board[0]);j++ {
			if board[j][i] != '.' {
				if flag[board[j][i] - '1'] {
					return false
				} else {
					flag[board[j][i] - '1'] = true
				}
			}
		}
	}
	for block:=0;block<9;block++{
		flag := make([]bool, 9)
		for i:=block/3*3;i<block/3*3+3;i++ {
			for j:=block%3*3;j<block%3*3+3;j++ {
				if board[i][j] != '.' {
					if flag[board[i][j] - '1'] {
						return false
					} else {
						flag[board[i][j] - '1'] = true
					}
				}
			}
		}
	}
	return true
}

func MainValidSudoku() {
	fmt.Println(isValidSudoku([][]byte {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}))
	//expected true
}


