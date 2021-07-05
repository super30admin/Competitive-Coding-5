class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        r = [set() for i in range(9)]
        c = [set() for i in range(9)]
        box = [set() for i in range(9)]
        
        for i in range(9):
            for j in range(9):
                cur = board[i][j]
                if cur!='.':
                    if cur in r[i]:
                        return False
                    else:
                        r[i].add(cur)
                    
                    if cur in c[j]:
                        return False
                    else:
                        c[j].add(cur)
                    
                    k = ((i // 3) * 3) + j // 3
                    
                    if cur in box[k]:
                        return False
                    else:
                        box[k].add(cur)
                    
                    
        return True
                    