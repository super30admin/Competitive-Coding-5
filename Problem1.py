# Time Complexity : O(n2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def isValidSudoku(self,board):
        if not board:
            return True 
        return self.helper1(board) and self.helper2(board) and self.helper3(board)
    
    def helper1(self,board):
        # Row Validation 
        for i in range(len(board)):
            temp = {}
            for num in board[i]:
                if num == '.':
                    continue
                if num not in temp:
                    temp[num] = True 
                else:
                    return False 
        return True 
    
    def helper2(self,board):
        # Column Validation 
        for j in range(len(board[0])):
            temp = {}
            for i in range(len(board)): 
                key = board[i][j]
                if key == '.':
                    continue 
                if key not in temp:
                    temp[key] = True 
                else:
                    return False 
        return True 
    
    def helper3(self,board):
        # 3 x 3 grid validation 
        r1,r2 = 0,2
        while r1 < len(board):
                c1, c2 = 0, 2 
                while c1 < len(board[0]):
                    temp ={} # hashset for the entire 3x3 grid
                    for i in range(r1,r2+1):
                        for j in range(c1,c2+1):        
                            key = board[i][j] 
                            if key == '.':
                                continue 
                            if key not in temp:
                                temp[key] = True 
                            else:
                                return False 
                    c1 = c2+1 
                    c2 = c2+3 
                r1 = r2+1
                r2 = r2+3
        return True     

if __name__ == "__main__":
    s = Solution()
    # board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
    board = [[".",".",".",".","5",".",".","1","."],[".","4",".","3",".",".",".",".","."],[".",".",".",".",".","3",".",".","1"],["8",".",".",".",".",".",".","2","."],[".",".","2",".","7",".",".",".","."],[".","1","5",".",".",".",".",".","."],[".",".",".",".",".","2",".",".","."],[".","2",".","9",".",".",".",".","."],[".",".","4",".",".",".",".",".","."]]
    res = s.isValidSudoku(board)
    print(res)
