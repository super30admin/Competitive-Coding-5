/*
    LC - Design Logger Rate Limiter
    TC - O(1)
    SC - O(n)
    Approach - Using hashmap to store the message & check if the duplicate exist.
            if exist check the timestamp if it is greater then update the timestamp 
            else return false;
*/

class Logger {

    HashMap<String, Integer> myMap;

    public Logger() {
        myMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(myMap.containsKey(message) && myMap.get(message) > timestamp) {
            return false;
        }

        myMap.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */