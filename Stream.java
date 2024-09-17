
import java.util.*;

public class Stream {

    HashMap<String, Integer> hs = new HashMap<>();

    public boolean checkTime(String message, int time) {

        // neg cases
        if (message == null || time < 0)
            return false;

        if (hs.containsKey(message)) {
            int prev = hs.get(message);
            if (time - prev >= 10) {
                hs.put(message, time);
                return true;
            } else
                return false;
        } else
            hs.put(message, time);

        return true;
    }

    public static void main(String[] args) {
        Stream st = new Stream();

        System.out.println(st.checkTime("message", 1));
        System.out.println(st.checkTime("message1", 4));
        System.out.println(st.checkTime("message2", 6));
        System.out.println(st.checkTime("message", 7));
        System.out.println(st.checkTime("message", 9));
        System.out.println(st.checkTime("message", 8));
        System.out.println(st.checkTime("message", 111));
        System.out.println(st.checkTime("message", 114));
    }
}
