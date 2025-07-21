'''
36. Valid Sudoku
Problem Link: https://leetcode.com/problems/valid-sudoku/description/
'''

# Time Complexity : O(1) for classic Sudoku board (9x9) and O(n^2) for general boards of size n x n
# Space Complexity : O(1) for classic Sudoku board (9x9) and O(n^2) for general boards of size n x n
# Did this code successfully run on Leetcode : Yes, this code runs successfully on Leetcode
# Any problem you faced while coding this : Yes, I faced some issues with understanding the constraints of the problem and how to implement the checks for rows, columns, and boxes efficiently.

import collections # humne Python ka collections module import kiya hai jismain defaultdict ka use karenge

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        '''
        Intuition:
        - Use hashset for each row
        - Use hashset for each column
        - Use hashset for each 3x3 sub-box
        - If a number is already in the respective hashset, return False
        - If the number is not in the respective hashset, add it to the hashset
        - If the number is '.', return True
        '''
        columns = collections.defaultdict(set) # humne columns ke liye bhi ek defaultdict banaya hai
        # key = column index, value = set of numbers in that column
        # yeh set mein hum unique numbers store karenge jo column mein hain
        # isse humein yeh pata chalega ki column mein koi duplicate number toh nahi hai
        rows = collections.defaultdict(set) # humne rows ke liye bhi ek defaultdict banaya hai
        # key = row index, value = set of numbers in that row
        # yeh set mein hum unique numbers store karenge jo row mein hain
        # isse humein yeh pata chalega ki row mein koi duplicate number toh nahi hai
        boxes = collections.defaultdict(set) # key = (row // 3, col // 3) # humne boxes ke liye bhi ek defaultdict banaya hai
        # key = (row // 3, col // 3), value = set of numbers in that 3x3 sub-box
        # yeh set mein hum unique numbers store karenge jo 3x3 sub-box mein hain
        # isse humein yeh pata chalega ki 3x3 sub-box mein koi duplicate number toh nahi hai

        for row in range(9): # hum 1 se lekar 9 tak ke rows par iterate kar rahe hain
            for col in range(9): # hum 1 se lekar 9 tak ke columns par iterate kar rahe hain
                if board[row][col] == '.': # agar cell mein '.' hai toh hum usse ignore karte hain
                    continue # kyunki '.' ka matlab hai ki cell khali hai
                # agar cell mein koi number hai toh hum check karte hain ki woh number rows, columns aur boxes mein hai ya nahi
                if board[row][col] in rows[row] or board[row][col] in columns[col] or board[row][col] in boxes[(row // 3, col // 3)]: # agar number rows, columns ya boxes mein hai toh
                    return False # hum False return karte hain kyunki yeh valid sudoku nahi hai
                # agar number rows, columns ya boxes mein nahi hai toh hum usse respective set mein add karte hain
                rows[row].add(board[row][col]) # rows set mein number add karte hain
                columns[col].add(board[row][col]) # columns set mein number add karte hain
                boxes[(row // 3, col // 3)].add(board[row][col]) # boxes set mein number add karte hain
        return True # agar humne saare cells check kar liye aur koi duplicate number nahi mila toh hum True return karte hain
        # iska matlab hai ki yeh valid sudoku hai
        # yeh function True ya False return karega based on the validity of the sudoku board