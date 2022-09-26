def beautifulArrangement(n):
        myset=set()
        self.count=0
        
        def beautiful(pos):
            if pos==n+1:
                self.count+=1
                return
            
            for i in range(1,n+1):
                if i not in myset:
                    if i%pos ==0 or pos%i ==0:
                        #Action
                        myset.add(i)
                        #Recurse
                        beautiful(pos+1)
                        #BAcktrack
                        myset.remove(i)
            
        
        beautiful(1)
        return self.count