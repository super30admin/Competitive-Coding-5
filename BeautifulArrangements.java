// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.HashSet;

public class BeautifulArrangements {
	 int result=0;
	    public int countArrangement(int n) {
	        HashSet<Integer> set=new HashSet<>();
	        helper(n,1,set);
	        
	        return result;
	    }
	    
	    public void helper(int n, int index, HashSet<Integer> set){
	         
	        if(index>n){ 
	            if(set.size()==n){
	                result++;
	            }
	            
	            return;
	        }
	        
	        for(int i=1;i<=n;i++){
	            if(!set.contains(i) && (i%index==0 || index%i==0)){
	                set.add(i);
	                helper(n,index+1,set);
	                set.remove(i);
	            }
	        }
	    }
}
