# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        arrR = [0 for _ in range(10)]
        
        for i in range(9):
            arrR = [0 for _ in range(10)]
            for j in range(9):
                if board[i][j] == '.':
                    continue
                if arrR[int(board[i][j])] == 1:
                    return False
                else:
                    arrR[int(board[i][j])] += 1
                    
        for i in range(9):
            arrR = [0 for _ in range(10)]
            for j in range(9):
                if board[j][i] == '.':
                    continue
                if arrR[int(board[j][i])] == 1:
                    return False
                else:
                    arrR[int(board[j][i])] += 1
        iStart = [0,3,6]
        jStart = [0,3,6]
        for si in iStart:
            for sj in jStart:
                arrR = [0 for _ in range(10)]
                for i in range(si, si+3):
                    for j in range(sj,sj+3):
                        print(i,j)
                        if board[i][j] == '.':
                            continue
                        if arrR[int(board[i][j])] == 1:
                            return False
                        else:
                            arrR[int(board[i][j])] += 1
        return True