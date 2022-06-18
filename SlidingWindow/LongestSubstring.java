public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        map.put(s.charAt(slow),slow);
        int fast = 1;
        int length = 1;
        while(fast < s.length() && slow < s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                length = Math.max(fast - slow, length);
                slow = Math.max(slow, map.get(c) + 1);
                map.put(c, fast);
            }
            if (fast == s.length() - 1){
                length = Math.max(s.length() - slow, length);
            }
            else{
                map.put(c, fast);
            }
            fast++;
        }

        return length;
    }
}
