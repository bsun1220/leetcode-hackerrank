public class MyAtoi {
    public int myAtoi(String s) {

        List<Integer> list = new ArrayList<>();
        boolean negative = false;
        boolean num = false;
        boolean start = false;
        String number = "0123456789";
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(!num && current == ' '){
                continue;
            }
            else if(!num && current == '-' ){
                negative = true;
                num = true;
            }
            else if (!num && current == '+'){
                num = true;
            }
            else if (!start && current == '0'){
                num = true;
            }
            else if (number.contains(Character.toString(current))){
                start = true;
                num = true;
                list.add(Character.getNumericValue(current));
            }
            else{
                break;
            }
        }

        if(list.size() > 10 || (list.size() == 10 && list.get(0) > 2)){
            if(negative){
                return Integer.MIN_VALUE;
            }
            else{
                return Integer.MAX_VALUE;
            }
        }

        int value = 0;
        for(int i = 0; i < list.size(); i++){
            int times = (int)Math.pow(10, list.size() - i - 1);
            int current = list.get(i);
            value += (times * list.get(i));

        }
        if(value < 0 && negative){
            return Integer.MIN_VALUE;
        }
        else if (value < 0 && !negative){
            return Integer.MAX_VALUE;
        }
        value = negative ? value * -1 : value;
        return value;
    }
}
