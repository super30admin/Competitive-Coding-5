#Time complexity: O(n^2)
#Space complexity: O(n^2)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = len(board)
        row = [set() for i in range(n)]
        col = [set() for i in range(n)]
        sBox = [set() for i in range(n)]
        
        for i in range(n):
            for j in range(n):
                curr = board[i][j]
                if curr.isdigit():
                    
                    if curr in row[i]:
                        return False
                    row[i].add(curr)
                    
                    if curr in col[j]:
                        return False
                    col[j].add(curr)
                    
                    if curr in sBox[(i//3*3)+(j//3)]:
                        return False
                    sBox[(i//3*3)+(j//3)].add(curr)
        return True
