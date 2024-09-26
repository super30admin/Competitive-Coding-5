# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
# // Your code here along with comments explaining your approach
	# Maintain 3 maps
	# RowMap = row0:(v1,v2,v3...v9), row1:(v1,v2,v3...v9), ... ,row9:(v1,v2,v3...v9)
	# ColMap = col0:(v1,v2,v3...v9), col1:(v1,v2,v3...v9), ... ,col9:(v1,v2,v3...v9)
	# BoxMap = box0:(v1,v2,v3...v9), box1:(v1,v2,v3...v9), ... ,box9:(v1,v2,v3...v9)
	
	# Check for duplicate entries in each hashmap and return False or True
	
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        RowMap = {}
        ColMap = {}
        BoxMap = {}
        
        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if num != ".":
                    num = int(num)
                    if i not in RowMap:
                        RowMap[i] = [num]
                    elif num in RowMap[i]:
                        return False
                    else:
                        RowMap[i].append(num)
                        
                    if j not in ColMap:
                        ColMap[j] = [num]
                    elif num in ColMap[j]:
                        return False
                    else:
                        ColMap[j].append(num)
                    
                    BoxIndex = (i // 3) * 3 + j // 3
                    if BoxIndex not in BoxMap:
                        BoxMap[BoxIndex] = [num]
                    elif num in BoxMap[BoxIndex]:
                        return False
                    else:
                        BoxMap[BoxIndex].append(num)
        return True