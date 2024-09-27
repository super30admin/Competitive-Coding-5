# Time Complexity :  O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for i in range(9):
            for j in range(9):

                if board[i][j] == '.':
                    continue

                if board[i][j] in rows[i]:
                    return False
                rows[i].add(board[i][j])

                if board[i][j] in cols[j]:
                    return False
                cols[j].add(board[i][j])
                    
                idx = (i // 3)*3 + j // 3
                if board[i][j] in boxes[idx]:
                    return False
                boxes[idx].add(board[i][j])

        return True

        