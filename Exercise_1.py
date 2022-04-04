
    # 36. Valid Sudoku
    # Time Complexity : O(nm)
    # Space Complexity : O(nm)


class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # result=[[],[],[],[],[],[],[],[],[]]
        sub_boards =[set() for _ in range(9)]

        if not board:
            return False

        for i in range(9):
            hash_set_row = set()
            hash_set_col = set()
            for j in range(9):
                if board[i][j] in hash_set_col and board[i][j] != '.' :
                    return False
                else:
                    hash_set_col.add(board[i][j])
                    
                if board[j][i] in hash_set_row and board[j][i] != '.':
                    return False
                else:
                    hash_set_row.add(board[j][i])
                    
                sub = (i // 3) * 3 + j // 3
                if board[i][j] in sub_boards[sub] and board[i][j] != '.' :
                    return False
                else:
                    # sub_boards[sub].append(board[i][j])
                    sub_boards[sub].add(board[i][j])
                
    
        return True