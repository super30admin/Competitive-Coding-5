# Time complexity: O(M*N)
# Space complexity: O(M*N) but it doesnt grow more than 9 * 9

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        seen = set()
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    row = f"R{i}{board[i][j]}"
                    col = f"C{j}{board[i][j]}"
                    block = f"B{(i // 3) * 3 + j // 3}{board[i][j]}" 
                    # This calculation is actually correct in this context, 
                    # it maps 9x9 grid into 9 blocks, each block having index from 0 to 8.
                    if row in seen or col in seen or block in seen:
                        return False
                    seen.add(row)
                    seen.add(col)
                    seen.add(block)
        return True
