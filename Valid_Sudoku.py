class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return false
       
       
        #Check for duplicates in row
        for i in range(len(board)):
            board_bool = [False]* 10
            for j in range(len(board[0])):
                if (board[i][j] != '.'):
                    #print(int(board[i][j]))
                    if board_bool[int(board[i][j])]:
                        return False
                    board_bool[int(board[i][j])]= True
            
    
        
        #Check for duplicates in column   
        for j in range(len(board[0])):
            board_bool = [False]* 10
            for i in range(len(board)):
                if (board[i][j] != '.'):
                    if board_bool[int(board[i][j])]:
                        return False
                    board_bool[int(board[i][j])]= True
            print(board_bool)
                
        #Check for duplicates in block
        for block in range(len(board)):
            board_bool = [False]* 10
            
            for i in range(block//3*3,block//3*3+3):
                for j in range(block%3*3,block%3*3+3):
                    if (board[i][j] != '.'):
                        if board_bool[int(board[i][j])]:
                            return False
                        board_bool[int(board[i][j])]= True
        return True
