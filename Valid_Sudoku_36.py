class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Array of fixed length
        # Time complexity O(N**2)
        # Space complexity O(N**2)
        N = 9
        rows = [[0] * N for _ in range(N)]
        cols = [[0] * N for _ in range(N)]
        boxes = [[0] * N for _ in range(N)]

        for i in range(N):
            for j in range(N):
                val = board[i][j]
                if val == ".":
                    continue

                pos = int(board[i][j]) - 1
                # row check
                if rows[i][pos] == 1:
                    return False
                rows[i][pos] = 1

                # col check
                if cols[j][pos] == 1:
                    return False
                cols[j][pos] = 1

                # boxes check
                idx = (i // 3) * 3 + (j // 3)
                if boxes[idx][pos] == 1:
                    return False
                boxes[idx][pos] = 1

        return True

    '''
        # Hash Set
        # Time complexity O(N**2)
        # Space complexity O(N**2)
        N = 9
        rows = [set() for _ in  range(N)]
        cols = [set() for _ in  range(N)]
        boxes = [set() for _ in  range(N)]

        for i in range(N):
            for j in range(N):
                val = board[i][j]
                if val == ".":
                    continue

                # row check
                if val in rows[i]:
                    return False
                rows[i].add(val)

                # col check
                if val in cols[j]:
                    return False
                cols[j].add(val)

                # boxes check
                idx = (i//3)*3 + (j//3)
                if val in boxes[idx]:
                    return False
                boxes[idx].add(val)

        return True
    '''



