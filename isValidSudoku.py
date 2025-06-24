# // Time Complexity :O(1) 81 elements
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :yes


# // Your code here along with comments explaining your approach
# maintain set ofr each row , col and each square and check if they are in that set if yes return false else add them..return true at the end






class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        dr=defaultdict(set)
        dc=defaultdict(set)
        dbox=defaultdict(set)
        for i in range(9):
            for j in range(9):

                if board[i][j]==".":
                    continue
                
                elif board[i][j] in dr[i] or  board[i][j] in dc[j] or board[i][j] in dbox[(i//3 ,j//3)]:return False
                if board[i][j]!=".":
                    dr[i].add(board[i][j])
                    dc[j].add(board[i][j])
                    dbox[(i//3 ,j//3)].add(board[i][j])
        return True
                
 
