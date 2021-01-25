# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes. It was hard to understand the problem 
# especially because I didn't know the rules of sudoku. It was easy to calculate 
# duplicates in the row/col but I had trouble finding out how to find uniques in each 3x3 box.
# It took basically the entire interview session to figure out what the interviewer 
# meant and I wasn't able to get the chance to code it.. but this took like 10 minutes doing it now


# Your code here along with comments explaining your approach


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return False
        #row
        for i in range(len(board)):
            seen = set()
            for j in range(len(board[0])):
                if board[i][j] != '.':
                    if board[i][j] in seen:
                        return False
                    else:
                        seen.add(board[i][j])
        #col
        for i in range(len(board)):
            seen = set()
            for j in range(len(board[0])):
                if board[j][i] != '.':
                    if board[j][i] in seen:
                        return False
                    else:
                        seen.add(board[j][i])
        
        #use two for loops 
        #create a string for each grid/box for gridBox
        seen = set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] != '.':
                    rowVal = i//3
                    colVal = j//3
                    val = [board[i][j]]
                    uniqueID = str(rowVal) + str(val) + str(colVal)
                    if uniqueID in seen:
                        return False
                    else:
                        seen.add(uniqueID)
                        
        return True