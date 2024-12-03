import java.util.HashMap;

public class Logger{
    HashMap<String, Integer> map;
    int TIMEOUT = 10;

    public Logger() {
        map = new HashMap<String, Integer>();    
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }

        if(timestamp - map.get(message) >= TIMEOUT){
            map.put(message, timestamp);
            return true;
        }else{
            return false;
        }
    }
}