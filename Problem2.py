	# Time Complexity : O(1) as the processing won't change with respect to input size.
    #if size of the board is variable then O(row*col)
	# Space Complexity : O(m)
	# Did this code successfully run on Leetcode : Yes
	# Any problem you faced while coding this : No

    class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        count = [0]*9
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] != ".":
                    a = int(board[i][j])
                    count[a-1] += 1
                    if count[a-1] > 1:
                        return False
            count = [0]*9
        count = [0]*9
        print("1")
        for j in range(len(board[0])):
            for i in range(len(board)):
                if board[i][j] != ".":
                    a = int(board[i][j])
                    count[a-1] += 1
                    if count[a-1] > 1:
                        return False
            count = [0]*9
        count = [0]*9
        print("2")
        for i in range(0,len(board),3):
            for j in range(0,len(board[0]),3):
                for k in range(i,i+3,1):
                    for l in range(j,j+3,1):
                        if board[k][l] != ".":
                            a = int(board[k][l])
                            count[a-1] += 1
                            if count[a-1] > 1:
                                return False
                count = [0]*9
        return True
                