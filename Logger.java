// Time Complexity : O(1)
// Space Complexity :O(1)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.Map;

public class TimedLogger {
	static Map<String, Integer> map=new HashMap<>();
public static boolean  RelayMessage(int time, String message)
{
	if(!map.containsKey(message))
	{
		map.put(message, time);
		return true;
	}
	else
	{
		int prevtime =map.get(message);
		if(time-prevtime>=10)
		{
			map.put(message, time);
			return true;
		}
		else {return false;}
	}
	
}

public static void main(String args[])
{
	System.out.println(RelayMessage(101,"ab"));
	System.out.println(RelayMessage(150,"abc"));
	System.out.println(RelayMessage(108,"ab"));
	System.out.println(RelayMessage(170,"abc"));
	System.out.println(RelayMessage(112,"ab"));
	System.out.println(RelayMessage(180,"abc"));
	
}
}
