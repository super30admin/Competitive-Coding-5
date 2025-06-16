/*Time Complexity – O(1)
The board size is fixed at 9x9 → 81 cells.
For each cell, we do:
1 lookup in rows[i]
1 lookup in cols[j]
1 lookup in boxes[boxIndex]
Each of those set operations is O(1) (average-case in unordered_set).*/

// Space Complexity – O(1)
// 9 unordered_sets for rows
// 9 unordered_sets for columns
// 9 unordered_sets for boxes
// Each set can contain at most 9 digits ('1' to '9')
// So total unique elements across all sets = 9 rows + 9 cols + 9 boxes × up to 9 digits
// Still bounded, not growing with input size
// Hence, O(1)



class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_set<char> row[9];
        unordered_set<char> col[9];
        unordered_set<char> box[9];
        for(int i=0; i<9; ++i){
            for(int j=0; j<9 ;++j){
                char c = board[i][j];
                if(c == '.') continue;

                int bI = (i/3) * 3 + j/3;

                if(row[i].count(c) || col[j].count(c) || box[bI].count(c)) return false;

                row[i].insert(c);
                col[j].insert(c);
                box[bI].insert(c);
            }
        }
        return true;
    }
};
