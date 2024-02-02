class Solution:
    """
      BF -> O N^2
      for each cell. O(N)
        check valid_row and valid_col and valid_grid
        valid_r 0 -> r -> rows - 1 O(n) 
        valid_c 0 -> c -> cols - 1 O(N)
        valid_grid  c % 3 r %3  O(N)


        3 -> 0 + offset * element per grid  = 0 + 1 * 3 = 3 first coord of the grid 
        element per grid + start_coord = 3 + 3 - 1 = 6 last coord of the grid

        valid_r 
        hashmap_idx
          0 -> r -> rows - 1 O(n
          each idx
            skip "."
            check the current val exists in the hashmap
            if it does => fail the check
            if it does not => add to the hashmap
    """ 

    def isValidSudoku(self, board: List[List[str]]) -> bool:
      rows = len(board)
      cols = len(board[0])

      def valid_row(r, c):
        # starting from 0 to end of board. check for dup
        dup = set()
        for i in range(cols):
          if board[r][i] == ".":
            continue
          if board[r][i] in dup:
            return False
          else:
            dup.add(board[r][i])
        return True
      
      def valid_col(r, c):
        dup = set()
        for i in range(rows):
          if board[i][c] == ".":
            continue
          if board[i][c] in dup:
            return False
          else:
            dup.add(board[i][c])
        return True

      def valid_grid(r, c):
        # Get the current grid_row, grid_col
        grid_r = r % 3
        grid_c = c % 3
        # Generate the coord for grid

        start_r_idx = grid_r * 3
        end_r_idx = start_r_idx + 3

        start_c_idx = grid_c * 3
        end_c_idx = start_c_idx + 3

        dup = set()

        for i in range(start_r_idx, end_r_idx):
          for j in range(start_c_idx, end_c_idx):
            # print("grid coord: ", i, j)
            if board[i][j] == ".":
              continue
            if board[i][j] in dup:
              return False
            else:
              dup.add(board[i][j])
        
        return True

      for r in range(rows):
        for c in range(cols):
          valid = valid_row(r, c) and valid_col(r, c) and valid_grid(r, c)
          if not valid:
            return False
      return True



