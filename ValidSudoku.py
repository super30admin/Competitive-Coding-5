#All TC on leetcode passed

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        #Here we create dictionary to hold elements present in each row, each column and each 3*3 block. This dictioanry has row/col/block position as key and set() as value. We traverse through every cell of matrix and check if that cell value is already present in that row, or in that column or in that block. If yes then we return False immediately. Else we keep traversing till all cell are covered.
        #Time complexity - O(9*9) => O(1)
        #Space complexity - O(9*9 + 9*9 + 9*9) => O(1) -For every row, column, block we maintain a new set.

        rows = collections.defaultdict(set)
        cols =  collections.defaultdict(set)
        blocks = collections.defaultdict(set)

        for i in range(9):
            for j in range(9):
                if board[i][j] != "." and (board[i][j] in rows[i] or board[i][j] in cols[j] or board[i][j] in blocks[str(i//3)+str(j//3)]):
                    return False
                elif board[i][j] != ".":
                    rows[i].add(board[i][j])
                    cols[j].add(board[i][j])
                    blocks[(str(i//3)+str(j//3))].add(board[i][j])
                
        return True

                    
                
                

        