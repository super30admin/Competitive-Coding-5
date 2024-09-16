#TimeComplexity:O(N*M) 
#SpaceComplexity: O(N) 3 sets of size N .
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        m=len(board);n=len(board[0])
        for i in board:
            rows=set()
            for j in i:
                if j=='.':
                    continue
                elif (j not in rows):
                    rows.add(j)
                else:
                    return False
        for i in range(n):
            cols=set()
            for j in board:
                if j[i]=='.':
                    continue
                elif j[i] not in cols:
                    cols.add(j[i])
                else:
                    print('cols')
                    return False 
        row_start=0;row_end=3
        col_start=0;col_end=3
        while col_end <= 9:
            while row_end <= 9:
                block=set()
                for i in range(row_start,row_end):
                    for j in range(col_start,col_end):
                        print(i,j)
                        if board[i][j]=='.':
                            continue
                        elif (board[i][j] not in block):
                            block.add(board[i][j])
                        else:
                            return False
                row_start+=3;row_end+=3
            row_start=0;row_end=3
            col_start+=3;col_end+=3


        return True