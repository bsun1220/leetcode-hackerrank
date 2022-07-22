public class LetterCombinations {
    List<String> list;
    Map<Integer, Integer> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put(7, 112);
        map.put(8, 116);
        map.put(9, 119);
        list = new ArrayList<>();

        if(digits.length() == 0){
            return list;
        }

        recurse(digits, 0, new StringBuilder(""));
        return list;

    }
    public void recurse(String digits, int index, StringBuilder sb){
        if(sb.toString().length() == digits.length()){
            list.add(sb.toString());
        }
        else{
            int num = Integer.parseInt(String.valueOf(digits.charAt(index)));
            if(num < 7){
                int ascii = 91 + 3 * num;
                for(int i = 0; i < 3; i++){
                    char letter = (char)(ascii + i);
                    sb.append(letter);
                    recurse(digits, index + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else{
                int ascii = map.get(num);
                int length = num % 2 == 1 ? 4 : 3;
                for(int i = 0; i < length; i++){
                    char letter = (char)(ascii + i);
                    sb.append(letter);
                    recurse(digits, index + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
