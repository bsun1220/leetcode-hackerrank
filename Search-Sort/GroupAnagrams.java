public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char [] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }
        for(String key : map.keySet()){
            list.add(map.get(key));
        }

        return list;

    }
}
