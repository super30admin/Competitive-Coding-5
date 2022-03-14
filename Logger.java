//Time: O(1)
//Space: O(M) -> number of messages stored in map

class Logger {

    //using hashmap to store message and timestamp
    private HashMap<String,Integer> msgDict;
    
    public Logger() {
        msgDict = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        //if map does not contain msg, 
        // we are seeing msg for 1st time, add to map and return true
        if(!this.msgDict.containsKey(message)) {
            this.msgDict.put(message, timestamp);
            return true;
        }
        
        //else get old time from map
        Integer oldTime = this.msgDict.get(message);
        
        //check if time diff >=10
        //if yes then add message with new timestamp
        //else return false
        if(timestamp - oldTime >= 10) {
            this.msgDict.put(message, timestamp);
            return true;
        } else return false;
    }
}