class Solution:
    
    """
    Description: Find if the sudoku is valid
    
    Time Complexicity = O(1) {fixed 81 items}
    Space Complexicity = O(1) {fixed size}
    
    Approach: 
    Create a set for each column, each row and each block
    Check if next value is present in running set -> False if "yes", otherwise True
    """
    
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        if board == None or len(board) == 0: return None
        
        # Check in columns
        for i in range(9):
            values = set()
            for j in range(9):
                current = board[i][j]
                if current in values: return False
                if current != ".": values.add(current)
                
        # Check in rows
        for i in range(9):
            values = set()
            for j in range(9):
                current = board[j][i]
                if current in values: return False
                if current != ".": values.add(current)
        
        # Check each block
        for x in range(3):
            for y in range(3):
                values = set()
                for j in range(y*3,(y+1)*3):
                    for i in range(x*3,(x+1)*3):
                        current = board[i][j]
                        if current in values: return False
                        if current != ".": values.add(current)

        return True
