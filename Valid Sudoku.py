#time: O(n^2)
#space: O(n)  
#leetcode:yes

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if(board==[] or len(board)==0):
            return True
        row=[{} for i in range(9)]
        column=[{} for i in range(9)]
        box=[{} for i in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j]!=".":
                    num=int(board[i][j])
                    boxid= (i//3)*3 +(j//3)
                    if num in row[i]:
                        return False
                    else:
                        row[i][num]=1
                        
                    if num in column[j]:
                        return False
                    else:
                        column[j][num]=1
                        
                    if num in box[boxid]:
                        return False
                    else:
                        box[boxid][num]=1
        return True                                   