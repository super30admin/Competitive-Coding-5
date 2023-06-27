/*

// Time Complexity : exponential n^n 
// Space Complexity : exponential n^n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Start with each number present in the array. as we proceed in the level we check the hashset true for the chosen 
and then iterate through rest of the elements in the hashset
If we encounter the level == number of elements then all possible number are used . solution found increase the result by 1;
Do the following by recursion.
When we come out of the recursion we will make the element in the hash set back to false that was choosen so that 
the state of the numbers used can be maintained.

*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
    int res{};
    void helper(vector<bool>& hash_set,int val,int level,int n){
        if(val%level == 0 || level%val == 0 ){
            if(level == n){
                res++;
                return;
            }
            hash_set[val] = true;
            for(int i{1};i<=n;++i){
                if(hash_set[i] == false){

                    helper(hash_set,i,level+1,n);

                }
                
            }
            hash_set[val] = false;
        }
    }

public:
    int countArrangement(int n) {
        vector<bool> hash_set(n+1,false);
        for(int i{1};i<=n;++i){
            helper(hash_set,i,1,n);
        }
        return res;
    }
};