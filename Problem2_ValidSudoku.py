# Time Complexity: O(mn), where m - num of rows, n - num of cols
# Space Complexity: O(1) 
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return []

        # Check each row for repetition
        for i in range(9):
            arr = [False for x in range(9)]
            for j in range(9):
                if board[i][j] != ".":
                    if arr[ord(board[i][j]) - ord('1')]:
                        return False
                    arr[ord(board[i][j]) - ord('1')] = True

        # Check each column for repetition
        for j in range(9):
            arr = [False for x in range(9)]
            for i in range(9):
                if board[i][j] != ".":
                    if arr[ord(board[i][j]) - ord('1')]:
                        return False
                    arr[ord(board[i][j]) - ord('1')] = True

        # Check each block for repetition
        for block in range(9):
            arr = [False for x in range(9)]
            row = block // 3 * 3
            col = block % 3 * 3
            for i in range(row, row + 3):
                for j in range(col, col + 3):
                    if board[i][j] != ".":
                        if arr[ord(board[i][j]) - ord('1')]:
                            return False
                        arr[ord(board[i][j]) - ord('1')] = True

        return True