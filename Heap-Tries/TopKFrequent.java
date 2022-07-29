public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(0, pq.remove().getKey());
        }

        return list;




    }
}
