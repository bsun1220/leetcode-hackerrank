public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if(p.length() > s.length()){
            return list;
        }

        Map<Character, Integer> pmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        for(char c : p.toCharArray()){
            pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        }

        int length = p.length();

        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }

        if(smap.equals(pmap)){
            list.add(0);
        }


        for(int end = length; end < s.length(); end++){
            int start = end - length;
            char cStart = s.charAt(start);
            smap.put(cStart, smap.get(cStart) - 1);
            if(smap.get(cStart) <= 0){
                smap.remove(cStart);
            }
            char cEnd = s.charAt(end);
            smap.put(cEnd , smap.getOrDefault(cEnd , 0) + 1);

            if(smap.equals(pmap)){
                list.add(start + 1);
            }
        }

        return list;
    }
}
