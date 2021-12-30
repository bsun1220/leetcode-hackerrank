import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder ret = new StringBuilder("");
        Stack<String> s = new Stack<>();
        int beginIndex = 0;
        int numPeriods = 0;
        path = path + '/';
        String substring = "";
        for(int i = 1; i < path.length(); i++)
        {
            Character c = path.charAt(i);

            if (c == '.')
            {
                numPeriods++;
            }
            else if (c == '/')
            {
                if(numPeriods == 2 && i - beginIndex == 3)
                {
                    if(!s.isEmpty())
                    {
                        s.pop();
                    }
                }
                else if(!(i - beginIndex == 1 || (numPeriods == 1 && i - beginIndex == 2)))
                {
                    substring = path.substring(beginIndex, i);
                    s.push(substring);
                }
                numPeriods = 0;
                beginIndex = i;
            }
        }

        if(s.isEmpty())
        {
            return "/";
        }
        while(!s.isEmpty())
        {
            ret.insert(0, s.pop());
        }
        return ret.toString();
    }
}
