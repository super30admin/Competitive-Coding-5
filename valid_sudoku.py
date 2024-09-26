# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        valid=[False for i in range(9)]
        flag=True
        print(valid)
        m=len(board)
        n=len(board[0])
        for i in range(m):
            valid=[False for k in range(9)]
            for j in range(n):
                if 1<=ord(board[i][j])-ord('0')<=9:
                    if valid[int(board[i][j])-1]==True: return False
                    valid[int(board[i][j])-1]=True
        for j in range(n):
            valid=[False for k in range(9)]
            for i in range(m):
                # print(valid)
                if 1<=ord(board[i][j])-ord('0')<=9:
                    if valid[int(board[i][j])-1]==True: return False
                    valid[int(board[i][j])-1]=True
        for block in range(9):
            valid=[False for k in range(9)]
            for i in range((block//3)*3,(block//3)*3+3):
                for j in range((block%3)*3,(block%3)*3+3):
                    if 1<=ord(board[i][j])-ord('0')<=9:
                        if valid[int(board[i][j])-1]==True: return False
                        valid[int(board[i][j])-1]=True
            print(valid)
        return True
        
                
                