// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # null
        if(board == None): 
            return False
        check = set()
        for r in range(len(board)):
            for c in range(len(board[0])):
                curr = board[r][c]
                if(curr != "."):
                    rString = "r" + str(r) + curr
                    if rString in check:
                        return False
                    cString = "c" + str(c) + curr
                    if cString in check:
                        return False
                    gridString = "g" + str((r//3)) + str((c//3)) + curr
                    if gridString in check:
                        return False
                    check.add(rString)
                    check.add(cString)
                    check.add(gridString)
                #print(check)
        return True