public class WordBreak {
    Set<String> set;
    Map<String, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        map = new HashMap<>();
        return recurse(s);

    }

    public boolean recurse(String s){
        if(s.length() == 0) return true;
        if(map.containsKey(s)) return map.get(s);

        for(String word : set){
            if(s.startsWith(word)){
                String rest = s.substring(word.length());
                if(recurse(rest)){
                    map.put(rest, true);
                    map.put(s, true);
                    return true;
                }
                map.put(rest, false);
            }
        }
        return false;
    }
}
