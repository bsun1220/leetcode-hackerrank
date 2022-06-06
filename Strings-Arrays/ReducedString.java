public class ReducedString {
    public static String superReducedString(String s) {
        Stack<Character> c = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < s.length(); i++){
            if(!c.isEmpty() && c.peek() == s.charAt(i)){
                c.pop();
            }
            else{
                c.push(s.charAt(i));
            }
        }
        while(!c.isEmpty()){
            sb.append(c.pop());
        }
        return sb.toString().equals("") ? "Empty String" : sb.reverse().toString();

    }
}
