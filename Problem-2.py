"""
Approach: maintiain 3 seperate sets for 3 rules. iterate from left top to right bottom and check if all 3 rules are followed, if not return fasle

TC: O(n)
SC: O(n)
"""
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        r = set()
        c = set()
        m = set()
        for i in range(9):
            for j in range(9):
                curr = board[i][j]
                if curr == '.':
                    continue
                else:
                    if ((curr, str(i))) in r:
                        return False
                    else:
                        r.add((curr, str(i)))

                    if ((curr, str(j))) in c:
                        return False
                    else:
                        c.add((curr, str(j)))

                    if ((curr, str(i // 3), str(j // 3))) in m:
                        return False
                    else:
                        m.add((curr, str(i // 3), str(j // 3)))
        return True

