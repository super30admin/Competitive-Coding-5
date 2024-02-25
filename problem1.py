# Time Complexity : O(N^2)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach

# Approach : We can use three dictionaries to track the visited one's so that
# whenever there is a conflict we will return false immediately.
# one dictionary to track the rows used by a number
# one dictionary to track the cols used by a number
# one dictionary to track the blocks used by a number, we can use the formula 3 * (row // 3)  + (col // 3)
# to calculate each block.


from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        visited_rows = {}
        visited_cols = {}
        visited_blocks = {}

        for element in range(1, 10):
            cur = str(element)
            visited_rows[cur] = set()
            visited_cols[cur] = set()
            visited_blocks[cur] = set()

        max_rows = len(board)
        max_cols = len(board[0])
        for row in range(max_rows):
            for col in range(max_cols):
                cur = board[row][col]
                if cur == ".":
                    continue
                if row in visited_rows[cur]:
                    return False
                else:
                    visited_rows[cur].add(row)
                if col in visited_cols[cur]:
                    return False
                else:
                    visited_cols[cur].add(col)

                cur_block = 3 * (row // 3) + (col // 3)
                print(cur_block)
                if cur_block in visited_blocks[cur]:
                    return False
                else:
                    visited_blocks[cur].add(cur_block)

        return True