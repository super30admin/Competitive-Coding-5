#Time Complexity:- O(n^2)
#Space Complexity:- O(n^2)

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row, column = [], []
        if board is None or  len(board)!=9 or len(board[0])!=9:
            return False 
        block = {}
        row ={}
        column={}
        for i in range(9):
            row[i] = set()
            column[i] = set()
            block[i] = set()
            
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == '.':
                    continue 
                val = ord(board[i][j]) - ord('0')

                ## row operation
                if val in row[i]:
                    return False
                row[i].add(val)

                ## column operation
                if val in column[j]:
                    return False
                column[j].add(val)

                
                #block operation
                idx = (i//3)*3+j//3
                if val in block[idx]:
                    return False
                block[idx].add(val)
        return True
        
        
        

        


        
        

