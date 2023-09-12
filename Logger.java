//TC =  O(1) time for the lookup.
//SC = O(M) size of incoming messages

class Logger{

    HashMap<String, Integer> hmap = new HashMap<String, Integer>();

    Logger(){
        this.hmap = new HashMap<String, Integer>();
    }

    public boolean shouldPrintMessage(int timestamp, String message){
        if(!hmap.containsKey(message)){
            hmap.put(message, timestamp);
            return true;
        }
        Integer older = hmap.get(message);
        if(timestamp - older >=10){
            hmap.put(message,timestamp);    
            return true;
        }else{
            return false;
        }
    }
}