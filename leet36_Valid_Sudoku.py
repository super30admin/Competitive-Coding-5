# Solution

# For S30 Solution
# // Time Complexity : O(M*N) perfect is, it is 3*M*N since we are iterating over the matrix thrice to validate rows, columns
#                      and boxes
# // Space Complexity : O(1), since we are creating constant boolean list of size 9
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to iterate over rows and columns while having a boolean list for each row and column when we are processing that
# perticular row and column. Update boolean list to see if a number is already used, if it is already set to True then
# return false, else keep going. For box do that same activity, only thing is inner loop ranges should be calculated using 
# the block number we are currently processing. rowStart = (block/3)*3, rowEnd = ((block/3)*3) + 3
# colStart = (block%3)*3, colStart = ((block%3)*3)+3

def isValidSudoku(board):

    # S30
    rowNums = len(board)
    colNums = len(board[0])

    if rowNums != 9 or colNums != 9:
        return False

    for i in range(rowNums):
        boolean = [False for _ in range(9)]
        for j in range(colNums):
            if board[i][j] == ".":
                continue
            if boolean[int(board[i][j])-1] == True:
                return False
            
            boolean[int(board[i][j])-1] = True
    
    for i in range(colNums):
        boolean = [False for _ in range(9)]
        for j in range(rowNums):
            if board[j][i] == ".":
                continue
            if boolean[int(board[j][i])-1] == True:
                return False
            
            boolean[int(board[j][i])-1] = True

    for block in range(9):
        boolean = [False for _ in range(9)]
        for i in range((block//3)*3,((block//3)*3)+3):
            for j in range((block%3)*3,((block%3)*3)+3):
                if board[i][j] == ".":
                    continue
                
                if boolean[int(board[i][j])-1] == True:
                    return False

                boolean[int(board[i][j])-1] = True

    return True

if __name__ == "__main__":
    board = [["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
    
    print(isValidSudoku(board))