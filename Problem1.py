class Solution(object):
    # tc : O(1), traversing each cell takes n2 but here n is a constant and it si 9 every time so its a constant time complexity
    # sc : O(1), we are using extar space of 3*81 elements but since we know the sudoko is of 9*9 81 and will always be this constant , the space complexity is also a constance space. 
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # intution : have extra arr for each row, cols and keep track of the element if that element is already visietd them we found a breach 
        # and return false , to keep track will have an arr of n size with 0's and in that arr will update the index where the element can be from 0 to 1 and again in iteration if we see the index to updated is already 1, found duplicate

        n = len(board) # 9

        rows = [[0]*n for _ in range(n)] # using each row of this n*n to keep track for each row of the sudoku
        cols = [[0]*n for _ in range(n)] # using each col of this to keep track for the col of the sudoku
        boxes = [[0]*n for _ in range(n)] # will use 3*3 matrix to keep track of the a box 

        for i in range(len(board)):
            for j in range(len(board)):

                # edge case if there is a dot then skip it
                if board[i][j] == ".":
                    continue
                
                # in a sorted array the element will be at the position of x-1 (0-8th indexed, 5th element wil be at index 4)
                idx = int(board[i][j]) -1 # as the value in the board is strings convert it to int to find its position

                # check in rows
                if rows[i][idx] == 1:
                    return False
                else:
                    rows[i][idx] = 1

                # check in cols
                if cols[j][idx]:
                    return False
                else:
                    cols[j][idx] = 1

                # check in the box 
                # the boxes array we use the rows for 0-2 and cols for 0-2 for the box 0
                # rows of 0-2, cols of 3-5 for the box 1 
                # boxes = [box0,box1,box2...box8]
                # lets we are looking at row 6, col 7 then this belong to the box8th index here is where we need to add the element to keep track of 3*3 matrix
                # to keep properly which row, col belogns to which box idx the 

                box_idx = (i//3)*3+(j//3) # 6//3, 7//3 gives  2*3 + 2 = 8  gives us the box idx belongs to 8th 
                # to identify the rows properly floor division gives alwasy to be in 0-2 and by *3 gives us the proper row idx and to differentiate to move from box0, box. 1 based on col will use the c//3 

                if boxes[box_idx][idx] == 1:
                    return False
                boxes[box_idx][idx] = 1


        return True


        




                

