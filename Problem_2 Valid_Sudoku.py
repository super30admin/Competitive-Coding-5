# // Time Complexity : O(9*9)
# // Space Complexity : O(9)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
def notInRow(arr, row):
    st = set()
    for i in range(0, 9):
        if arr[row][i] in st:
            return False

        if arr[row][i] != '.':
            st.add(arr[row][i])
    return True

def notInCol(arr, col):
    st = set()

    for i in range(0, 9):
        if arr[i][col] in st:
            return False
        if arr[i][col] != '.':
            st.add(arr[i][col])
    return True

def notInBox(arr, startRow, startCol):
    st = set()

    for row in range(0, 3):
        for col in range(0, 3):
            curr = arr[row + startRow][col + startCol]
            if curr in st:
                return False
            if curr != '.':
                st.add(curr)

    return True

def isValid(arr, row, col):
    return (notInRow(arr, row) and notInCol(arr, col) and
            notInBox(arr, row - row % 3, col - col % 3))


def isValidConfig(arr, n):
    for i in range(0, n):
        for j in range(0, n):
            if not isValid(arr, i, j):
                return False

    return True



if __name__ == "__main__":

    board = [['5', '3', '.', '.', '7', '.', '.', '.', '.'],
             ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
             ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
             ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
             ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
             ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
             ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
             ['.', '.', '.', '4', '1', '9', '.', '.', '5'],
             ['.', '.', '.', '.', '8', '.', '.', '7', '9']]

    if isValidConfig(board, 9):
        print("True")
    else:
        print("False")


