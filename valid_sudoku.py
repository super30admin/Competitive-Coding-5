
# Time complexity - O(1) since we will be traversing only 81 cells in sudoku board
# Space - O(1) since  we will only be storing values 81 total values in board
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        rows = [set() for i in range(9)]
        columns = [set() for i in range(9)]
        boxes = [set() for i in range(9)]
        
        # validate a board
        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if num != '.':
                    box_index = (i // 3) * 3 + j // 3

                    # check if the element is in the hashset 
                    if num in rows[i] or num in columns[j] or num in boxes[box_index]:
                        return False

                    # put the element into hashset
                    rows[i].add(num)
                    columns[j].add(num)
                    boxes[box_index].add(num)
        
        return True
