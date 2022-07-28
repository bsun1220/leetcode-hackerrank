public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        List<String> digits = new ArrayList<>();
        Stack<Integer> amount = new Stack<>();
        boolean findDigit = false;
        while(index < s.length()){
            char c = s.charAt(index);
            if(Character.isDigit(c)){
                digits.add(Character.toString(c));
                findDigit = true;
                index++;
            }
            else if (findDigit){
                int repeat = Integer.parseInt(String.join("", digits));

                digits.clear();
                amount.push(repeat);
                findDigit = false;
                stack.push(index);
                index++;
            }
            else if (c == ']'){
                int recentInd = stack.pop();
                int numRepeat = amount.pop();
                String rep = s.substring(recentInd + 1, index);
                StringBuilder sub = new StringBuilder();
                for(int i = 0; i < numRepeat; i++){
                    sub.append(rep);
                }

                int len = String.valueOf(numRepeat).length();
                int endBeg = recentInd - len;
                s = s.substring(0, endBeg) + sub.toString() + s.substring(index + 1);
                index = endBeg + sub.toString().length();
            }
            else{
                index++;
            }


        }
        return s;
    }
}
