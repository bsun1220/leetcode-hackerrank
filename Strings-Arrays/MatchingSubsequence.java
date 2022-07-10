public class MatchingSubsequence {
    public int numMatchingSubseq(String s, String[] words) {

        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int total = 0;
        for(String word: map.keySet()){
            total = isMatch(s, word) ? total + map.get(word) : total;
        }
        return total;
    }

    public boolean isMatch(String root, String subword){
        if(root.length() < subword.length()){
            return false;
        }

        int nIndex = 0;
        for(int i = 0; i < root.length(); i++){
            if(subword.charAt(nIndex) == root.charAt(i)){
                nIndex++;
            }
            if(nIndex == subword.length()){
                return true;
            }
        }
        return false;
    }
}
