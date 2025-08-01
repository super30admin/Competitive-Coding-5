//Time Complexity: O(1). HashMap lookup, insert, and update all take constant time.
//Space Complexity (SC):O(m). m is the number of unique messages stored in the map.

//Use a HashMap to store the last printed timestamp for each message.
//For each new call, check if the message exists in the map.
//If it doesn't exist or timestamp difference ≥ 10, update the timestamp and return true; otherwise, return false.

public class Logger {
    private Map<String, Integer> lastPrinted;

    public Logger() {
        lastPrinted = new HashMap<>();
    }

    // Core logic: decide whether to print the message or not
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!lastPrinted.containsKey(message)) {
            lastPrinted.put(message, timestamp);
            return true;
        }

        int lastTime = lastPrinted.get(message);
        if (timestamp - lastTime >= 10) {
            lastPrinted.put(message, timestamp);
            return true;
        }

        return false;
    }
}