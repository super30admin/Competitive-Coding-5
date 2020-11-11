"""
Time - O(N^2)
Space - O(N^2)
Leetcode - yes
problems - no
"""
class Solution:
    
    def isValidSudoku(self, board: List[List[str]]) -> bool:
    
        self.puzzle = board
        self.convert_to_int()
        print(self.puzzle)
        self.check_win()
        return self.check_win()
    
    def convert_to_int(self):
        for row in range(9):
            for col in range(9):
                if(self.puzzle[row][col] != '.'):
                    self.puzzle[row][col] = int(self.puzzle[row][col])
                else:
                    self.puzzle[row][col] = 0
                    
        
    def check_win(self):
        for row in range(9):
            if not self.__check_row(row):
                return False
        for column in range(9):
            if not self.__check_column(column):
                return False
        for row in range(3):
            for column in range(3):
                if not self.__check_square(row, column):
                    return False
        self.game_over = True
        return True

    def __check_block(self, block):
        temp = []
        for i in block:
            if i != 0:
                temp.append(i)
                
        return len(set(temp)) == len(temp)
                
                

    def __check_row(self, row):
        return self.__check_block(self.puzzle[row])

    def __check_column(self, column):
        return self.__check_block(
            [self.puzzle[row][column] for row in range(9)]
        )

    def __check_square(self, row, column):
        return self.__check_block(
            [
                self.puzzle[r][c]
                for r in range(row * 3, (row + 1) * 3)
                for c in range(column * 3, (column + 1) * 3)
            ]
        )