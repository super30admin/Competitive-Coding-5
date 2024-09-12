"""
Rasika Sasturkar
Time Complexity: O(1)
Space Complexity: O(1)
"""


def isValidSudoku(board) -> bool:
    """
    Used 9 sets to keep track of row elements, used 9 sets to
    keep track of column elements. Each 3*3 grid has the coordinates
    (r // 3, c // 3). 9 sets using a map can be used to keep track
    of grid elements.
    """
    # null case
    if board is None:
        return False

    set_rows = [set() for _ in range(9)]
    set_cols = [set() for _ in range(9)]
    grid_map = {}

    for r in range(9):
        for c in range(9):
            if board[r][c] == ".":
                continue
            if board[r][c] in set_rows[r] or board[r][c] in set_cols[c]:
                return False
            set_rows[r].add(board[r][c])
            set_cols[c].add(board[r][c])

            # check if grid coordinates exists
            if (r // 3, c // 3) not in grid_map:
                grid_map[(r // 3, c // 3)] = set()
            if board[r][c] in grid_map[(r // 3, c // 3)]:
                return False
            grid_map[(r // 3, c // 3)].add(board[r][c])

    return True


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    board1 = [["5", "3", ".", ".", "7", ".", ".", ".", "."]
        , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
        , [".", "9", "8", ".", ".", ".", ".", "6", "."]
        , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
        , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
        , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
        , [".", "6", ".", ".", ".", ".", "2", "8", "."]
        , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
        , [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
    print(isValidSudoku(board1))  # returns True
    board2 = [["8", "3", ".", ".", "7", ".", ".", ".", "."]
        , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
        , [".", "9", "8", ".", ".", ".", ".", "6", "."]
        , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
        , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
        , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
        , [".", "6", ".", ".", ".", ".", "2", "8", "."]
        , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
        , [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
    print(isValidSudoku(board2))  # returns False


if __name__ == "__main__":
    main()