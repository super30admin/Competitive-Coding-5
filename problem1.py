#Time complexity O(N)
#Time complexity O(K) No of permutations
#Space Complexity O(N)
class Solution:   
    def countArrangement(self, n: int) -> int:
        
        #Initialze DataStructures
        data = set()
        self.counter=0
        
        #Recusrion func
        def recursive(x):
            #Base Condition
            if len(data)%x !=0 and x%len(data)!=0:
                return 
            
            if len(data)==n:
                self.counter+=1
                
            #Logic
            for x in range(1,n+1):
                if x not in data:
                    data.add(x)
                    recursive(x)
                    data.remove(x)
            
        recursive(1)
        
        return self.counter
        
                    
                    

        
        
                    
        
        
        
        
        
        
        
        
        
        
        
