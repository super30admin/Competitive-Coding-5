// #https://leetcode.com/problems/valid-sudoku/description/

var isValidSudoku = function(board) {
    //Time Complexity : O(N X M)
    //Space Complexity : O(N)
    let row = Array.from({length:9},()=>new Set())
    let col = Array.from({length:9},()=>new Set())
    let box = Array.from({length:9},()=>new Set())

    for(let i=0;i<board.length;i++){
        for(let j=0;j<board.length;j++){
            if(board[i][j] == "."){
                continue
            }
            else{
                let value = board[i][j]
                let boxNumber = Math.floor(i/3)*3+Math.floor(j/3)
                if(row[i].has(value) || col[j].has(value) || box[boxNumber].has(value)){
                    return false
                }
                else{
                    row[i].add(value)
                    col[j].add(value)
                    box[boxNumber].add(value)
                }
            }

        }
    }
    return true
};