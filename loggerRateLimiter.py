# // Time Complexity :O(1)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class Logger:
    def __init__(self):
        self.mdict = {}                                     # init a hashmap for O(1) search 

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.mdict:                       # add message to map if not present 
            self.mdict[message] = timestamp
            return True
        
        if message in self.mdict:                           # if present check latest value as timestamp
            if timestamp - self.mdict[message] >= 10:
                self.mdict[message] = timestamp             #update
                return True
            else:
                return False


            


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)