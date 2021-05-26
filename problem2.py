class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        for k in range(9):
            hashmap = []
            for i in range(10):
                hashmap.append(False)
            for l in range(9):
                if board[k][l]!=".":
                    if hashmap[int(board[k][l])]==True:
                        return False
                    hashmap[int(board[k][l])] = True

        for k in range(9):
            hashmap = []
            for i in range(10):
                hashmap.append(False)
            for l in range(9):
                if board[l][k]!=".":
                    if hashmap[int(board[l][k])]==True:
                        return False
                    hashmap[int(board[l][k])] = True

        for i in range(9):
            hashmap = []
            for l in range(10):
                hashmap.append(False)
            for j in range(((i//3)*3),((i//3)*3)+3):
                for k in range((i%3)*3,((i%3)*3)+3):
                    if board[j][k]!=".":
                        if hashmap[int(board[j][k])]==True:
                            return False
                        hashmap[int(board[j][k])] = True

        return True
                    
