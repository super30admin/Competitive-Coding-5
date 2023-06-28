#Time complexity is O(1) 
#Space complexity is O(1)
#Code ran successfully on leetcode
#Faced no issues while coding this problem

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        #Taking the count of number of rows and columns
        rows=len(board)
        cols=len(board[0])
        #base condition
        if(board==None or rows<9 or cols<9):
            return False
        
        #Iterating through each row and finding whether 
        #there any repitition of values in the list
        for i in range(0,rows):
            li=[0 for k in range(0,rows)]
            for j in range(0,cols):
                if(board[i][j]!='.'):
                    #If there is any repitition of the value, we will return False
                    if(li[int(board[i][j])-1]):
                        return False
                    #else we will change the value in the hashset of that value to True
                    else:
                        li[int(board[i][j])-1]=1
        
        #Iterating through each column and finding whether 
        #there any repitition of values in the list
        for j in range(0,cols):
            li=[0 for k in range(0,cols)]
            for i in range(0,rows):
                if(board[i][j]!='.'):
                    #If there is any repitition of the value, we will return False
                    if(li[int(board[i][j])-1]):
                        return False
                    #else we will change the value in the hashset of that value to True
                    else:
                        li[int(board[i][j])-1]=1
        
        #We will be dividing the entire matrix into 3*3 blocks
        #and we will be checking in each of the block whether there any repititions or not
        for i in range(0,9):
            li=[0 for k in range(0,9)]
            for r in range(i//3*3,i//3*3+3):
                for c in range((i%3)*3,(i%3)*3+3):
                    if(board[r][c]!='.'):
                        #If there is any repitition of the value, we will return False
                        if(li[int(board[r][c])-1]):
                            return False
                        #else we will change the value in the hashset of that value to True
                        else:
                            li[int(board[r][c])-1]=1
        #If the test cases passes all the above conditions, we will return True
        return True

