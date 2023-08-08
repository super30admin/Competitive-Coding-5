# // Time Complexity :O(1)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_set,col_set,sub_grid=[],[],[]
        for i in range(9):
            row_set.append(set())
            col_set.append(set())
            sub_grid.append(set())
        for r in range(9):
            for c in range(9):
                ele=board[r][c]
                if(ele=='.'):
                    continue
                if ele in row_set[r]:
                    return False
                row_set[r].add(ele)
                if ele in col_set[c]:
                    return False
                col_set[c].add(ele)
                idx=(r//3)*3+(c//3)
                if ele in sub_grid[idx]:
                    return False
                sub_grid[idx].add(ele)
        return True


        
                   