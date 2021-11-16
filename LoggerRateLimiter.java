// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.HashMap;

public class LoggerRateLimiter {
	HashMap<String,Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
       map=new HashMap();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(!map.containsKey(message)){
            map.put(message,timestamp);
            return true;
        }
        
        if(map.containsKey(message) && timestamp<(map.get(message)+10)){
            return false;
        }else{
            map.put(message,timestamp);
            return true;
        }
           
    }
}
