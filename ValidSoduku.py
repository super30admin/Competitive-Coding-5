# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = 9
        rows = [set() for _ in range(n)]
        cols = [set() for _ in range(n)]
        boxes = [set() for _ in range(n)]

        for i in range(n):
            for j in range(n):
                if board[i][j] == '.':
                    continue

                if board[i][j] in rows[i]:
                    return False
                rows[i].add(board[i][j])
            
                if board[i][j] in cols[j]:
                    return False
                cols[j].add(board[i][j])

                idx = i// 3 * 3 + j // 3
                if board[i][j] in boxes[idx]:
                    return False
                boxes[idx].add(board[i][j])

        return True
        
