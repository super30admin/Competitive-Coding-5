# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Your code here along with comments explaining your approach
#Maintain a hasmap for rows, cols and squares. If a particular nuber was seen in that row and col in the hashmap we return false.
#For squares we store the row and col number divide by 3 and store it in hashmap to see which square it exists in. There would be 9 squares therefore we can divide and find which sqaure it belongs to.
#
#
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        rows = collections.defaultdict(set)
        cols = collections.defaultdict(set)
        squares = collections.defaultdict(set)


        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    continue
                if ((board[i][j] in rows[i]) or (board[i][j] in cols[j]) or (board[i][j] in squares[(i//3, j//3)])):
                    return False
                rows[i].add(board[i][j])
                cols[j].add(board[i][j])
                squares[(i//3, j//3)].add(board[i][j])
        return True

