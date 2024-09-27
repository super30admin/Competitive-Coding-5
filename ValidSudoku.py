class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        #Time Complexity: O(9**2)
        #Space Complexity: O(1)
        #We can set hashset or hashmap for checking if the value is repeated or not
        
        cols=collections.defaultdict(set) #Key will be the col number and value will be the set of numbers in the col
        rows=collections.defaultdict(set)#Key will be the row number and value will be the set of numbers in the col
        squares=collections.defaultdict(set) #Key will be the row/3 and col/3 --> square index and value will be the set of numbers in the col
        
        for r in range(9):
            for c in range(9):
                #skip if empty
                if board[r][c] == ".":
                    continue
                
                #check if we found a dupe
                if board[r][c] in rows[r] or board[r][c] in cols[c] or board[r][c] in squares[(r//3, c//3)]:
                    return False
                
                print(squares)
                
                cols[c].add(board[r][c])
                rows[r].add(board[r][c])
                squares[(r//3, c//3)].add(board[r][c])
                    
        return True
                    
        
