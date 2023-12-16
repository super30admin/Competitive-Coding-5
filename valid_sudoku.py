# TC: O (M X N)
# SC: O (M X N)

class Solution:
    def checkrows(self,board):
        dict1={}
        for i in range(0,len(board)):
            dict1[i]=[]
            for j in range(0,len(board[0])):
                if board[i][j] not in dict1[i] and board[i][j]!=".":
                    dict1[i].append(board[i][j])
                elif board[i][j] in dict1[i] and board[i][j]!=".":
                    return False
        print(dict1)
        return True

    def checkcolumns(self,board):
        dict1={}
        for i in range(0,len(board)):
            dict1[i]=[]
            for j in range(0,len(board[0])):
                if board[j][i] not in dict1[i] and board[j][i]!=".":
                    dict1[i].append(board[j][i])
                elif board[j][i] in dict1[i] and board[j][i]!=".":
                    return False
        print(dict1)
        return True

    def checkbox(self,board):
        dict3={}
        centers=[[1,1],[1,4],[1,7],[4,1],[4,4],[4,7],[7,1],[7,4],[7,7]]
        dir1=[[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1],[-1,-1]]
        count=0
        for center in centers:
            dict3[count]=[]
            for d in dir1:
                # print(str(center[0]+d[0])+" "+str(center[1]+d[1]))
                dict3[count].append(board[center[0]][center[1]])
                if board[center[0]+d[0]][center[1]+d[1]] not in dict3[count] and board[center[0]+d[0]][center[1]+d[1]]!=".":
                    dict3[count].append(board[center[0]+d[0]][center[1]+d[1]])
                    print(str(center[0]+d[0])+" "+str(center[1]+d[1]))
                elif board[center[0]+d[0]][center[1]+d[1]] in dict3[count] and board[center[0]+d[0]][center[1]+d[1]]!=".":
                    return False
                    
            count+=1
        print(dict3)
        return True


    def isValidSudoku(self, board: List[List[str]]) -> bool:
        return self.checkrows(board) and self.checkcolumns(board) and  self.checkbox(board)
        
        
        