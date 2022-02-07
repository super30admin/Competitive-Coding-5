
#Time Complexity O(N)
#Space Complexity O(N)
class Logger(object):

    def __init__(self):
        self.data_dict = dict()
        """
        Initialize your data structure here.
        """
        

    def shouldPrintMessage(self, timestamp, message):
        if message in self.data_dict.keys():
            value = self.data_dict[message]
            if value <=  timestamp:
                self.data_dict[message] = timestamp + 10                
                return True
            else:
                return False
        else:
            self.data_dict[message] = timestamp + 10
            return True
             
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
