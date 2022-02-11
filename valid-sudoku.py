'''
TC: O(N^2)
SC: O(N)
'''
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rlen = len(board)
        clen = len(board[0])
        
        # row
        for i in range(rlen):
            hmap = set()
            for j in range(clen):
                if board[i][j] == ".":
                    continue
                if board[i][j] in hmap:
                    return False
                hmap.add(board[i][j])
        # col
        for j in range(clen):
            hmap = set()
            for i in range(rlen):
                if board[i][j] == ".":
                    continue
                if board[i][j] in hmap:
                    return False
                hmap.add(board[i][j])
        
        # box
        boxes = [set() for _ in range(rlen)]
        
        for i in range(rlen):
            for j in range(clen):
                if board[i][j] == ".":
                    continue
                idx = (i // 3) * 3 + j // 3
                if board[i][j] in boxes[idx]:
                    return False
                boxes[idx].add(board[i][j])
        
        
        return True