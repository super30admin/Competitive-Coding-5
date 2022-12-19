# Time Complexity: O(N^2)
# Space Complexity: O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here we maintain hashset for every row, column and box
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        cell = [[set() for _ in range(3)] for _ in range(3)]

        for i in range(9):
            for x in range(9):
                value = board[i][x]
                if value == ".":
                    continue
                # integer division here would give us the box number
                if (value in rows[i]) or (value in cols[x]) or (value in cell[i//3][x//3]):
                    return False
                rows[i].add(value)
                cols[x].add(value)
                cell[i//3][x//3].add(value)
        return True