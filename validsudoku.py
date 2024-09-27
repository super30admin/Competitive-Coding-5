
# Time Complexity : O(N^2)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach



from collections import defaultdict
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = len(board)
        rowdict = defaultdict(set)
        coldict = defaultdict(set)
        subboxdict = defaultdict(set)
                 
        for i in range(n):
            for j in range(n):
                row = i//3
                col = j//3
                if board[i][j] == '.':
                    continue
                    
                if board[i][j] in rowdict[i]:
                    return False
                else:
                    rowdict[i].add(board[i][j])
                    
                
                if board[i][j] in coldict[j]:
                    return False
                else:
                    coldict[j].add(board[i][j])
                

                if board[i][j] in subboxdict[(row,col)]:
                    return False
                else:
                    subboxdict[(row,col)].add(board[i][j])
               
        return True
                
        