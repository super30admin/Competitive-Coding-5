'''

Time Complexity : O(1)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

 I use three list, each containing nine hashmaps. First list contains nested hashmaps for storing elements present in each
 horizontal row. We use hashmaps so that search operation is O(1). If any elements are found occuring in the hashmaps already
 while traversing the sodoku grid, we return False
'''

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        h = [{} for _ in range(9)]
        v = [{} for _ in range(9)]
        b = [{} for _ in range(9)]

        for i in range(0,9):
            for j in range(0,9):
                c = board[i][j]

                if c == ".":
                    continue

                if c not in h[j]:
                    h[j][c] = 1
                else:
                    return False

                if c not in v[i]:
                    v[i][c] = 1
                else:
                    return False

                index = 3 * (i//3)  + (j//3)

                if c not in b[index]:
                    b[index][c] = 1

                else:
                    return False

        return True