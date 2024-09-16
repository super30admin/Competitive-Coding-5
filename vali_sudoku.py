# Time Complexity: O(9x9)
# Space Complexity: O(9)
class Solution(object):

    def isValidSudoku(self, board):
        #         Creating sets for row, col and box for every element
        row = [set() for i in range(9)]
        col = [set() for i in range(9)]
        box = [set() for i in range(9)]
        #         Iterate over the board and if it is not "." then we will chekc if it is valid in row , col and in box , if not we will return False else return True
        for i in range(9):
            for j in range(9):
                curr = board[i][j]

                if curr != ".":
                    if curr in row[i]:
                        return False
                    else:
                        row[i].add(curr)

                    if curr in col[j]:
                        return False
                    else:
                        col[j].add(curr)

                    index = ((i // 3) * 3) + j // 3

                    if curr in box[index]:
                        return False
                    else:
                        box[index].add(curr)

        return True

        """
        :type board: List[List[str]]
        :rtype: bool
        """
