/**
 * @param {character[][]} board
 * @return {boolean}
 * https://leetcode.com/problems/valid-sudoku/description/
 Intuition:
To validate a Sudoku board, we need to ensure that each number from 1 to 9 appears at most once in every row, column, and 3×3 subgrid. We can do this efficiently in a single pass by keeping three arrays of sets: one for rows, one for columns, and one for subgrids.
As we iterate through each cell, we skip empty cells and check whether the current value has already been seen in its corresponding row, column, or subgrid.
The subgrid index is computed using the formula (Math.floor(i / 3)) * 3 + (Math.floor(j / 3)).
If a duplicate is found in any of these sets, the board is invalid.
 Otherwise, we record the value in all three sets and continue scanning. 
 If the entire board is processed without conflicts, we return true.
T.C: O(1)
S.C: O(1)
 */
var isValidSudoku = function (board) {
    const rowSet = Array.from({ length: 9 }, () => new Set());
    const colSet = Array.from({ length: 9 }, () => new Set());
    const gridSet = Array.from({ length: 9 }, () => new Set());

    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            const currVal = board[i][j];
            if (currVal === '.') continue;
            // has formula to derive the location
            const gridIdx = (Math.floor(i / 3)) * 3 + (Math.floor(j / 3));
            // duplicates check
            if (
                rowSet[i].has(currVal) ||
                colSet[j].has(currVal) ||
                gridSet[gridIdx].has(currVal)
            ) return false;
            // if not add it to the set
            rowSet[i].add(currVal);
            colSet[j].add(currVal);
            gridSet[gridIdx].add(currVal);

        }
    }
    return true;
};