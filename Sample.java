// Time Complexity : 0(M*N)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func isValidSudoku(_ board: [[Character]]) -> Bool {
        
        for row in 0..<board.count {
            var hashset = [Character:Bool]()  
            for col in 0..<board[0].count {
                if board[row][col] == "." {
                    continue
                }
                if let char = hashset[board[row][col]] {
                    return false
                } else {
                    hashset[board[row][col]] = true
                } 
            }
        }
        for col in 0..<board[0].count {
            var hashset = [Character:Bool]()  
            for row in 0..<board.count {
             if board[row][col] == "." {
                    continue
                }
                if let char = hashset[board[row][col]] {
                    return false
                } else {
                    hashset[board[row][col]] = true
                } 
            }
        }
 guard isValidBlock(board: board, rows: 0...2, columns: 0...2) else { return false }
        guard isValidBlock(board: board, rows: 0...2, columns: 3...5) else { return false }
        guard isValidBlock(board: board, rows: 0...2, columns: 6...8) else { return false }
        
        guard isValidBlock(board: board, rows: 3...5, columns: 0...2) else { return false }
        guard isValidBlock(board: board, rows: 3...5, columns: 3...5) else { return false }
        guard isValidBlock(board: board, rows: 3...5, columns: 6...8) else { return false }
        
        guard isValidBlock(board: board, rows: 6...8, columns: 0...2) else { return false }
        guard isValidBlock(board: board, rows: 6...8, columns: 3...5) else { return false }
        guard isValidBlock(board: board, rows: 6...8, columns: 6...8) else { return false }
        
        return true
    }
    
    func isValidBlock( board: [[Character]], rows: ClosedRange<Int>, columns: ClosedRange<Int>) -> Bool {
        var hashset = [Character: Bool]()
        for row in rows {
            for col in columns {
              if board[row][col] == "." {
                    continue
                }
                if let char = hashset[board[row][col]] {
                    return false
                } else {
                    hashset[board[row][col]] = true
                } 
            }
        }
        return true
    }