
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if len(board) == 0:
            return False
        
        row = [{} for i in range(9)]
        col = [{} for i in range(9)]
        boxes = [{} for i in range(9)]
        
        #validate the board
        
        for i in range(9):
            for j in range(9):
                number = board[i][j]
                #Since all boxes need not be filled
                if number!='.':
                    number = int(number)
                    
                    box_index = (i//3)*3  + j//3
                    
                    row[i][number] = row[i].get(number,0)+1
                    col[j][number] = col[j].get(number,0)+1
                    
                    boxes[box_index][number] = boxes[box_index].get(number,0)+1
                    
                    if row[i][number] > 1 or col[j][number] > 1 or boxes[box_index][number] > 1:
                        return False
        
        return True