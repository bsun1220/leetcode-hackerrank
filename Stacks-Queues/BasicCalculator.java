public class BasicCalculator {
    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        int index = 1;
        while(index < s.length() - 1){
            char c = s.charAt(index);
            if(c != '*' && c != '/'){
                index++;
                continue;
            }
            int before = gatherBefore(s, index - 1);
            int after = gatherAfter(s, index + 1);
            int result = 0;
            result = c == '*' ? before * after : before / after;

            int beforeLength = String.valueOf(before).length();
            int afterLength = String.valueOf(after).length();
            System.out.println("before " + s);
            if(s.charAt(index - beforeLength ) == '-' && result == 0){
                s = s.substring(0, index - beforeLength + 1) + result + s.substring(index + afterLength + 1);
            }
            else{
                s = s.substring(0, index - beforeLength) + result + s.substring(index + afterLength + 1);
            }


            System.out.println("after " + s);
            index = index - beforeLength + 1;
        }
        index = 1;


        while(index < s.length() - 1 ){
            char c = s.charAt(index);
            if(c != '+' && c != '-'){
                index++;
                continue;
            }
            int before = gatherBefore(s, index - 1);

            int after = gatherAfter(s, index + 1);

            int beforeLength = String.valueOf(before).length();
            int afterLength = String.valueOf(after).length();

            int result = 0;
            result = c == '+' ? before + after : before - after;
            s = s.substring(0, index - beforeLength) + result + s.substring(index + afterLength + 1);
            index = index - beforeLength + 1;
        }
        return Integer.parseInt(s);
    }

    public int gatherBefore(String s, int index){
        StringBuilder sb = new StringBuilder("");
        for(int i = index; i >= 0; i--){
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                if(c == '-') sb.append(c);
                break;
            }
            sb.append(c);
        }
        return Integer.parseInt(sb.reverse().toString());
    }

    public int gatherAfter(String s, int index){
        StringBuilder sb = new StringBuilder("");
        for(int i = index; i < s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c) && i != index){
                break;
            }
            sb.append(c);
        }
        return Integer.parseInt(sb.toString());
    }
}
