# time: O(n2)= O(9*9)= O(1)
# space: O(n)
class Solution(object):
    def isValidSudoku(self, board):
        # check rows
        for i in range(len(board)):
            uniVals = set()
            row = board[i]
            for j in row:
                if j in uniVals and j != '.':
                    # print("1")
                    return False
                uniVals.add(j)
        
        for i in range(len(board[0])):
            col =[]
            uniVals = set()
            for j in range(len(board)):
                col.append(board[j][i])
            for j in range(len(col)):
                if col[j] in uniVals and col[j] != '.':
                    # print("2")
                    return False
                uniVals.add(col[j])

        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                uniVals = set()
                for r in range(3):
                    for c in range(3):
                        idx_r, idx_c = r + i, c + j
                        # print(idx_r, idx_c)
                        if board[idx_r][idx_c] in uniVals and board[idx_r][idx_c] != '.':
                            # print("3")
                            return False
                        uniVals.add(board[idx_r][idx_c])
        return True
        