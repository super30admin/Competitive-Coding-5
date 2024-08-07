#// Time Complexity : O(1) 
# // Space Complexity : O(N) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class Logger:

    def __init__(self):
        self.dicti={}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:

        if message not in self.dicti:
            self.dicti[message]=timestamp+10
            return True
        else:
            if timestamp>=self.dicti[message]:
                self.dicti[message]=timestamp+10
                return True

            else:
                return False

# Approach:
# 1. Create a dictionary to store the messages and their corresponding timestamps.
# 2. Check if the message is already in the dictionary. If not, add it to the dictionary
# and return True. If the message is already in the dictionary, check if the current timestamp
# is greater than or equal to the stored timestamp. If it is, update the stored timestamp and return
# True. If the current timestamp is less than the stored timestamp, return False.
