# Time Complexity: O(1)
# Space Complexity: O(1)
# Ran on Leetcode: Yes

class Solution:
    def getBox(self, i, j):
        return (i // 3) * 3 + (j // 3)
    
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_dic = {}
        col_dic = {}
        box_dic = {}
        for i in range(len(board)):
            for j in range(len(board[0])):
                elem = board[i][j]
                if elem != ".":
                    if i not in row_dic:
                        row_dic[i] = set()
                    if elem in row_dic[i]:
                        return False
                    row_dic[i].add(elem)
                    if j not in col_dic:
                        col_dic[j] = set()
                    if elem in col_dic[j]:
                        return False
                    col_dic[j].add(elem)
                    box_num = self.getBox(i, j)
                    if box_num not in box_dic:
                        box_dic[box_num] = set()
                    if elem in box_dic[box_num]:
                        return False
                    box_dic[box_num].add(elem)
        return True