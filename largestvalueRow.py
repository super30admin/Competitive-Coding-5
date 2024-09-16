# node-> val, left, right
# 1
#2   3
#4,5    6
#7
# Time Complexity O(n)
# Space Complexity O(n)
def findMax(root):
    if(root==None):
        return []
    o = []
    q = deque([root]) #1    
    size = 1
    while(len(q)>0):
        max = float("-inf")
        for i in range(0,size): #(0,2) 1
            e = q.popleft() # 4
            if(e.val>max):
                max = e.val # 6, 7
            if(e.left!=None):
                q.append(e.left) # 7
            if(e.right!=None):
                q.append(e.right) # 5   #[]
        
        o.append(max) # 1, 3, 6 ,7
        size = len(q) #2 # 3 #1 #0
    
    return o


# Time Complexity O(n)
# Space Complexity O(h)
def findMaxRec(root):
    o = [] # 1,3,6,7
    def findMax(root,d): # 6,3
        nonlocal o
        if(root==None):
            return
        if(d>len(o)):
           o.append(root.val)
        else:
            if(o[d-1]<root.val):
                o[d-1] = root.val
        findMax(root.left,d+1)
        findMax(root.right,d+1)

    findMax(root,1)
    return o
