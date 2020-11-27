// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    const s=new Set();
    
    for(let i=0; i<9; i++) {
        for(let j=0;j<9;j++) {
            if(board[i][j]=='.') continue;
            
            let row="row"+i+board[i][j];
            let col="col"+j+board[i][j];
            let box="box"+Math.floor(i/3)+"-"+Math.floor(j/3)+board[i][j];
            
            console.log(s)

            if(s.has(row)) return false;
            if(s.has(col)) return false;
            if(s.has(box)) return false;
         
            s.add(row);
            s.add(col);
            s.add(box);
        }
    } 
    return true;  
};