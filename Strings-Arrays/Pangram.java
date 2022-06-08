public class Pangram {
    public static String pangrams(String s) {
        Set<Character> set = new HashSet<>();
        for(char i = 'a'; i <= 'z'; i++){
            set.add(i);
        }
        s = s.toLowerCase();
        for(int k = 0; k < s.length(); k++){
            char c = s.charAt(k);
            if(set.contains(c)){
                set.remove(c);
            }
        }
        String result = set.size() == 0 ? "pangram" : "not pangram";
        return result;
    }
}
