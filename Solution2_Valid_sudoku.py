// Time Complexity : O(3 n*n) 
// Space Complexity : O(4n) 3 hashmaps+ 1 list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
1. This ia a brute force approach
2. Check for duplicates in each row if all true move on to columns 
   else return False
3. Check for duplicates in each row if all true move on to columns
   else return False
4. Check for duplicates in each valid sudoku box
   if any is False return False
5. return True

'''

class Solution:
    
    def check_duplicates_row(self,board,row_num,row_len):
        h=set()
        for i in range(0,row_len):
            if board[row_num][i]!='.':
                if board[row_num][i] in h:
                    return False
                else:
                    h.add(board[row_num][i])
        return True
    
    def check_duplicates_col(self,board,col_num,col_len):
        h=set()
        for i in range(0,col_len):
            if board[i][col_num]!='.':
                if board[i][col_num] in h:
                    return False
                else:
                    h.add(board[i][col_num])
        return True
                    
    def check_duplicates_block(self,board,i,j):
        dir=[[-1,-1],[-1,0],[-1,1],
             [0,-1],[0,0],[0,1],
             [1,-1],[1,0],[1,1]]
        h=set()
        for v in dir:
            if board[v[0]+i][v[1]+j]!='.':
                if board[v[0]+i][v[1]+j] in h:
                    return False
                else:
                    h.add(board[v[0]+i][v[1]+j])
        return True
            
        
        
    
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_len= len(board)
        col_len= len(board[0])
        
        r=set([self.check_duplicates_row(board,row,row_len) for row in range(0,row_len)])
        if len(r)>1:
            return False
        
        if len(set([self.check_duplicates_col(board,col,col_len) for col in range(0,col_len)]))>1:
            return False
        
        
        sb=[self.check_duplicates_block(board,v[0],v[1])for v in [[1,1],[1,4],[1,7],[4,1],[4,4],[4,7],[7,1],[7,4],[7,7]]]
        if len(set(sb))>1:
            return False
        
        print(r)
        print(sb)
        
        return True
        
        
        
        
        