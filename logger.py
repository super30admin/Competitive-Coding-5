# TC: O(1)
# SC: O(n)

class Logger(object):

    def __init__(self):
        self.logDict = {}

    def shouldPrintMessage(self, timestamp, message):
        """
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message in self.logDict:
            difference = self.logDict[message] - timestamp
            if difference < 10:
                return False
            else:
                self.logDict[message] = timestamp
                return True
        else:
            self.logDict[message] = timestamp
            return True

l = Logger()

print(l.shouldPrintMessage(9,"foo"))
print(l.shouldPrintMessage(14,"foo"))
print(l.shouldPrintMessage(21,"foo"))
print(l.shouldPrintMessage(25,"foo"))
