# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashSet. Iterate over the board and assign the row, col and box values as value in row, value in col, value in box row//3 and col//3
# Then check if the cell is empty and row, col and box value is not in Hashset then add it to HashSet
# If it is already in HashSet return False


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        seen = set()
        for i in range(9):
            for j in range(9):
                value = board[i][j]
                row = value + "seen in row" + str(i)
                col = value + "seen in col" + str(j)
                box = value + "seen in box" + str(i // 3) + "-" + str(j // 3)
                if value != ".":
                    if row not in seen:
                        if col not in seen:
                            if box not in seen:
                                seen.add(row)
                                seen.add(col)
                                seen.add(box)
                            else:
                                return False
                        else:
                            return False
                    else:
                        return False
        return True