/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    let map = new Map();
    let rows = new Array(9).fill().map(() => new Set());
    let cols = new Array(9).fill().map(() => new Set());
    let boxes = new Array(9).fill().map(() => new Set());

    for(i = 0; i < 9; i++) {
        for(j = 0; j < 9; j++) {
           if(board[i][j] !== ".") {
                if(rows[i].has(board[i][j])) {
                    return false;
                }
                rows[i].add(board[i][j]);

                if(cols[j].has(board[i][j])){
                    return false;
                }
                cols[j].add(board[i][j]);

                let idx = Math.floor(i/3)*3+ Math.floor(j/3);
                if(boxes[idx].has(board[i][j])) {
                    return false;
                }
                boxes[idx].add(board[i][j]);
           }
       }
    }
       return true;
    
};