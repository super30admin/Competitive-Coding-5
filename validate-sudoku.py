class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        vertical = []
        hori = []
        inside = []
        for i in range(len(board[0])):
            vertical.append([])
            hori.append([])
            inside.append([])

        for i in range(len(board)):
            for j in range(len(board[0])):
                # print(vertical)
                box_index = (i // 3) * 3 + (j // 3)
                if board[i][j] != '.':
                    if (board[i][j] in vertical[i]) or (board[i][j] in hori[j]) or (board[i][j] in inside[box_index]):
                        return False
                    vertical[i].append(board[i][j])
                    hori[j].append(board[i][j])
                    inside[box_index].append(board[i][j])
        return True
        # time and space=O(1)