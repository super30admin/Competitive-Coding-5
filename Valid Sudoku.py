class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        if(board == None or len(board) == 0 or len(board[0]) == 0):
            return False
        
        #1. read all the rows
        #2. read all the columns
        #3. read 3x3 sub matrxi in the board
        
        n = len(board)
        m = len(board[0])
        hashMap = {}
        
        #1. read all the rows
        for i in range(0, n):
            hashMap.clear()
            for j in range(0, m):
                element = board[i][j]
                if element.isdigit():
                    element = int(element)
                    if element not in hashMap:
                        hashMap[element] = 1
                    else:
                        return False
        
        hashMap.clear()
        #2. read all the columns
        for i in range(0, m):
            hashMap.clear()
            for j in range(0, n):
                element = board[j][i]
                if element.isdigit():
                    element = int(element)
                    if element not in hashMap:
                        hashMap[element] = 1
                    else:
                        return False
        
        #3. read 3x3 sub matrix in the boar
        hashMap.clear()
        x = 0
        y = 0
        while(x < 9):
            for i in range(x, x+3):
                for j in range(y, y+3):
                    element = board[i][j]
                    if element.isdigit():
                        element = int(element)
                        if element not in hashMap:
                            hashMap[element] = 1
                        else:
                            return False
            y = y + 3
            hashMap.clear()
            if(y == 9):
                x = x + 3
                y = 0
                                  
        return True
