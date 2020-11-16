#Time Complexity : O(1)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Iterating through the board we keep a seen set and check if that value is already seen in that row, column or box. We add (row, num) and (num, col) in the seen to keep a difference between the two. And we add (row/3, col/3, num) to identify the box. 

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        seen = set()
        for r in range(len(board)):
            for c in range(len(board[0])):
                if board[r][c] != ".":
                    num, row, col, box = board[r][c], r, c, (r//3, c//3)
                    if (row, num) in seen or (num, col) in seen or (box, num) in seen:
                        return False
                    seen.add((row, num))
                    seen.add((num, col))
                    seen.add((box, num))

        return True
