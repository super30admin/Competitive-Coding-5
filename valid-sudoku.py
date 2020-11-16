# Time Complexity: O(m*n) - size of board - O(1) since it's a 9*9 board
# Space Complexity: O(m*n) - size of board - O(1) since it's a 9*9 board
# Approach: Traverse the board. For every cell that is not '.' add an entry to a set with the row/column or box index. If the value is seen in the set at any point, the board is not valid.
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # Initialize a set to capture seen values
        seen = set()
        
        def is_seen(s):
            if s in seen:
                return False
            else:
                seen.add(s)
                return True
        
        for i in range(9):
            for j in range(9):
                char = board[i][j]
                if char != '.':
                    if not is_seen(char + "row" + str(i)) or \
                    not is_seen(char + 'col' + str(j)) or \
                    not is_seen(char + 'box' + str(i//3) + ',' + str(j//3)):
                        return False
        return True