# TC: O(n*n), in this question it will be always O(9*9)
# SC: O(n*n), , in this question it will be always O(9*9)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        set_r =set()
        set_c = set()
        set_boxes = set()
        for r in range(len(board)):
            for c in range(len(board[0])):
                
                if board[r][c] !='.':
                    if (r,board[r][c]) in set_r or (board[r][c],c) in set_c or (r//3,c//3, board[r][c]) in set_boxes:
                        return False
                    set_r.add((r,board[r][c]))
                    set_c.add((board[r][c],c))
                    set_boxes.add((r//3, c//3,board[r][c]))
                
        return True
                
        