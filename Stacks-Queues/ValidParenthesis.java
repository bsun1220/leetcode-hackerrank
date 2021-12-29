import java.util.*;

public class ValidParenthesis {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c)){stack.push(c);}
            else
            {
                if(stack.isEmpty()){return false;}
                char pre = stack.pop();
                if(c != map.get(pre)){return false;}
            }
        }
        return stack.isEmpty();
    }
}
