#Time Complexity: O(1)
#Space Complexity: O(1)
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        seen = set()
        
        for r in range(9):
            for c in range(9):
                num = board[r][c]
                if num == '.':
                    continue
                
                row_key = "row{}-{}".format(r, num)
                col_key = "col{}-{}".format(c, num)
                block_key = "block{}-{}-{}".format(r // 3, c // 3, num)

                print(block_key)
                
                if row_key in seen or col_key in seen or block_key in seen:
                    return False
                
                seen.add(row_key)
                seen.add(col_key)
                seen.add(block_key)
        
        return True
                