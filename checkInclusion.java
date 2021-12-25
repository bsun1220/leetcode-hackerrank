import java.util.*;

public class checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++)
        {
            Character s = s1.charAt(i);
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }

        int start = 0;
        int end = 0;
        int count = map.size();

        while(end < s2.length())
        {
            Character s = s2.charAt(end);
            if(map.containsKey(s))
            {
                map.put(s, map.get(s) - 1);
                if(map.get(s) == 0)
                {
                    count--;
                }
            }
            if(end - start + 1 < s1.length())
            {
                end++;
            }
            else if (end - start + 1 == s1.length())
            {
                if(count == 0)
                {
                    return true;
                }
                Character i = s2.charAt(start);

                if(map.containsKey(i))
                {
                    map.put(i, map.get(i) + 1);
                    if(map.get(i) == 1)
                    {
                        count++;
                    }
                }
                start++;
                end++;
            }

        }
        return false;
    }
}
