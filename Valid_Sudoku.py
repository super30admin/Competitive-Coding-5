class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)] 
        grid = [set() for _ in range(9)]

        for row in range(len(board)): 
            for col in range(len(board[0])):

                value = board[row][col] 
                if value != ".":
                    # If we have seen the value previously in same row, it is a violation
                    if value in rows[row]:
                        return False

                    # If we have seen the value previously in same col, it is a violation
                    if value in cols[col]:
                        return False

                    # Compute in which grid we are currently
                    grid_num = 3 * (row // 3) + (col//3)

                    # If we have seen the value previously in same grid, it is a violation
                    if value in grid[grid_num]:
                        print(grid)
                        return False

                    # Add values in sets corresponding to the row, col and grid
                    rows[row].add(value)
                    cols[col].add(value)
                    grid[grid_num].add(value)
        return True


### Complexity Analysis ###
# Time Complexity: O(1) --> Since the sudoku board is of fixed size, the iteration will be counted as constant time
# Space Complexity: O(1) --> Since the sudoku board is of fixed size, the space occupied by arrays will also be counted as constan