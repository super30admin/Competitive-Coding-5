from ast import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rowDict = {}
        colDict = {}
        blockDict = {}
        for r in range(len(board[0])):
            rowDict[r] = []
            for c in range(len(board)):
                if r not in colDict:
                    colDict[r] = []
                if board[r][c] in rowDict[r] and board[r][c] != ".":
                    return False
                else:
                    rowDict[r].append(board[r][c])
                if board[c][r] in colDict[r] and board[c][r] != ".":
                    return False
                else:
                    colDict[r].append(board[c][r])
                rc = 3 * (r // 3) + c // 3
                cc = 3 * (r % 3) + c % 3
                if r not in blockDict.keys():
                    blockDict[r] = []
                if board[rc][cc] in blockDict[r] and board[rc][cc] != '.':
                    return False
                else:
                    blockDict[r].append(board[rc][cc])
        return True