
#Problem 2: Valid Sudoku
#Time Complexity O(n) , size of sudoku, which is fixed
#Space Complexity O(n), size of sudoku, which is fixed

'''
Brute force: Keep 27 hashsets (constant space, since always 9x9)
one for each row and one for each column, one for each block. Traverse the hashset accordingly
and check if element is not in hashset and smaller than 9 , we continue, else , return false.
Can we do it with less space?
'''


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return False
        columns=[set() for i in range(9)]
        rows=[set() for i in range(9)]
        boxes=[[set() for i in range(3)] for i in range(3)]

        for i in range(len(board)):
            for j in range(len(board[0])):
                value=board[i][j]
                if value==".":
                    continue
                if value in rows[i] :
                    return False
                rows[i].add(value)
                if value in columns[j] :
                    print(j)
                    print(columns[j])
                    print(value)
                    return False
                columns[j].add(value)
                if value in boxes[i//3][j//3]:
                    return False
                boxes[i//3][j//3].add(value)

        return True
