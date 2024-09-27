// Time Complexity : O(n) where n=9
// Space Complexity : O(n) where n=9
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was not able to complete the code duing mock interview but was able to finish the code after the interview.


/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    let mapRow = new Map();
    let mapCol = new Map();
    let mapBox = new Map();
    
    // Creating Hash Map and checking the unique value
    for(let i=0;i<9;i++) {
        for(let j=0;j<9;j++) {
            let cell = board[i][j];
            if(cell !== '.') {
                //Row
                if(mapRow.has(i) && mapRow.get(i).has(cell)) return false;
                else {
                    if(!mapRow.has(i)) {
                        let set = new Set();
                        set.add(cell);
                        mapRow.set(i,set);
                    } else {
                        mapRow.get(i).add(cell)
                    } 
                }
                
                //Column
                if(mapCol.has(j) && mapCol.get(j).has(cell)) return false;
                else {
                    if(!mapCol.has(j)) {
                        let set = new Set();
                        set.add(cell);
                        mapCol.set(j,set);
                    } else {
                        mapCol.get(j).add(cell);
                    } 
                }
                
                //3*3 matrix
                let index = Math.floor(i/3) * 3 + Math.floor(j/3);
                if(mapBox.has(index) && mapBox.get(index).has(cell)) return false;
                else {
                    if(!mapBox.has(index)) {
                        let set = new Set();
                        set.add(cell);
                        mapBox.set(index,set);
                    } else {
                        mapBox.get(index).add(cell);
                    }
                }
            }   
        }
    }
    return true;
};