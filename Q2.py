#########  Valid Sudoku

# Time Complexity : O(9*9) = O(1)
# Space Complexity : O(1) since we will only need 3*9 extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# create hashmaps for row, column and boxes and keep adding the element while traversing the grid. If an element is already present it is invalid

def valid_sudoku(board):
        N = 9

        rows = [set() for _ in range(N)]
        cols = [set() for _ in range(N)]
        boxes = [set() for _ in range(N)]

        for r in range(N):
            for c in range(N):
                val = board[r][c]
                
                if val == ".":
                    continue

                if val in rows[r]:
                    return False
                rows[r].add(val)
     
                if val in cols[c]:
                    return False
                cols[c].add(val)

                idx = (r // 3) * 3 + c // 3
                if val in boxes[idx]:
                    return False
                boxes[idx].add(val)

        return True
