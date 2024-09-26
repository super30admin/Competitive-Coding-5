# Approach: One iteration

# Here we will maintain three lists all containing 9 hash-maps:
# 1) rows: It will hold the value present in box in that row as key and its frequency as value
# 1) columns: It will hold the value present in box in that column as key and its frequency as value
# 1) boxes: It will hold the value present in box in that 3X3 grid as key and its frequency as value

# In rows list each hashmap will hold the key-value pairs for that row
# In columns list each hashmap will hold the key-value pairs for that column
# In boxes list each hashmap will hold the key-value pairs for that grid

# Also we will get index of a value in any cell using following formula:
# index = (row // 3) * 3 + (column // 3)
# We will use the above index to store key-value pairs in boxes hashmap

# So in any hashmap in any list if we find frequency of any one element more than 1 then it will return False.

# Time Complexity: O(1)
# Space Complexity: O(1)
# Here both the complexities are constant because maximum time and space we are going to utilize would not exceed 81
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board == None or len(board) == 0:
            return True
         
        rows = [{} for i in range(9)]
        columns = [{} for i in range(9)]
        boxes = [{} for i in range(9)]

        # validate a board
        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if num != '.':
                    num = int(num)
                    box_index = (i // 3 ) * 3 + j // 3
                    
                    # keep the current cell value
                    rows[i][num] = rows[i].get(num, 0) + 1
                    columns[j][num] = columns[j].get(num, 0) + 1
                    boxes[box_index][num] = boxes[box_index].get(num, 0) + 1
                    
                    # check if this value has been already seen before
                    if rows[i][num] > 1 or columns[j][num] > 1 or boxes[box_index][num] > 1:
                        return False         
        return True
                    
        