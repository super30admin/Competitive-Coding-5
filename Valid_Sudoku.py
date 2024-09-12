# Time complexity : O(m*n)
# Space complexity : O(1) --> since there will only be 9 elements in the hashmap
# Leetcode : Solved and submitted

class Solution:
    def isValidSudoku(self, board):
      # find rows and columns of the board
        rows = len(board)
        cols = len(board[0])
        
        # maintaing a hashmap for the numbers seen so far
        nums = {}
        box = 0
        
        # for each row and each column, we traverse by looking at one value at a time
        for i in range(rows):
            for j in range(cols):
                # calculate the box number using row and col index, since we have 9 boxes
                box = i //3 * 3 + j //3
                # find the curr number by using the char at the particular index
                curr_num = (ord(board[i][j]) - ord('0'))
                row = i
                col = j
                # if we find a '.', then we simply continue
                if board[i][j] == '.':
                    continue
                    
                # if the element is present in hashmap, then we check for row, col and box number
                # if any one of them is same, then sudoku is not valid, otherwise we add the element in hashmap with tuple as (row, col, box)
                if curr_num in nums:
                    if nums[curr_num]:
                        for a,b,c in nums[curr_num]:
                            #print(curr_num, a, b, c)
                            if a == row or b == col or c == box:
                                #print(nums)
                                return False
                    nums[curr_num].append([i,j,box])
                else:
                  # otherwise this is the first time we have encountered this, so we add it to the hashmap
                    nums[curr_num] = [(i,j,box)]
        return True
