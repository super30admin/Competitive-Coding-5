// Please Let me know if you have better solution. This takes more time run time on leet code
// Time Complexity : O(nm)
//      n: number of rows
//      m:number of columns
//    Iterate all the colums
// Space Complexity :O(nm)
//      n: number of rows
//      m:number of columns
//    Queue contains atleast the half of the locations
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// Your code here along with comments explaining your approach
// Using Approach: BFS
// We know water travels from high to low
// Reverse is also true i.e low to high
// But high to low is not possible that is the point of intersection of two oceans
public class Problem3 {
    // neighbors left, right, up, down
    int[][] neighbors = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    // global values
    int colLength;
    int rowLength;
    /** find meeting point of two ocean*/
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // result
        List<List<Integer>> result = new ArrayList<>();
        // edge case
        if(matrix == null || matrix.length == 0)
            return result;
        // initilaze the row and col
        rowLength = matrix.length;
        colLength = matrix[0].length;
        // Set for visited loaction -> i, j
        HashSet<List<Integer>> pacificHS =  new HashSet<>();
        HashSet<List<Integer>> atlanticHS = new HashSet<>();
        // Queue for BFS
        Queue<List<Integer>> pacificQ=  new LinkedList<>();
        Queue<List<Integer>> atlanticQ =  new LinkedList<>();
        // for getting last and first row
        for(int j =0; j < colLength; j++){
            // first row to Pacific
            List<Integer> listObjPacific = new ArrayList<>();
            listObjPacific.add(0);
            listObjPacific.add(j);
            pacificQ.add(listObjPacific);
             // first last to Atlantic
             List<Integer> listObjAtlantic = new ArrayList<>();
            listObjAtlantic.add(rowLength-1);
            listObjAtlantic.add(j);
            atlanticQ.add(listObjAtlantic);
        }
        // adding first column to Pacific
        for(int i = 1; i < rowLength; i++){
            List<Integer> listObj = new ArrayList<>();
            listObj.add(i);
            listObj.add(0);
            pacificQ.add(listObj);
        }
         // adding last column to Atlantic
        for(int i = 0; i < rowLength-1; i++){
            List<Integer> listObj = new ArrayList<>();
            listObj.add(i);
            listObj.add(colLength-1);
            atlanticQ.add(listObj);
        }
        // do bfs on Pacific
        bfs(pacificQ, pacificHS, matrix);
        // do bfs on atlantic
        bfs(atlanticQ, atlanticHS, matrix);
        // find intersection of both set
        for(List<Integer> temp: pacificHS){
            if(atlanticHS.contains(temp))
                result.add(temp);
        }
        // return result
        return result;
    }
    /** BFS traversal */
    private void bfs(Queue<List<Integer>> myQueue, HashSet<List<Integer>> result, int[][] matrix){
        // iterate queue
        while(!myQueue.isEmpty()){
            // current
            List<Integer> current =  myQueue.poll();
            // not already processed
            if(!result.contains(current)) {
                result.add(current);
                // process neighbors
                for(int[] neighbor:neighbors){
                    int row = neighbor[0] + current.get(0).intValue();
                    int col = neighbor[1] + current.get(1).intValue();
                    // in bound
                    if(row >= 0 && row <  rowLength && col >=0 && col < colLength){
                        // temp location
                        List<Integer> tempNeighbor = new ArrayList<>();
                        tempNeighbor.add(row);
                        tempNeighbor.add(col);
                        // check low -> high value and location not processed
                        if(matrix[current.get(0).intValue()][current.get(1).intValue()] <= matrix[row][col] && (!result.contains(tempNeighbor))) {
                            myQueue.add(tempNeighbor);
                        }
                    }
                }
            }
        }
    }
}