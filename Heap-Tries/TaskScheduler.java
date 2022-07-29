public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0){
            return tasks.length;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((char1, char2) ->
                Integer.compare(map.get(char1), map.get(char2)));

        int total = 0;
        while(!map.isEmpty()){
            for(char c : map.keySet()){
                pq.add(c);
                if(pq.size() > n + 1){
                    pq.remove();
                }
            }
            int size = pq.size();
            while(!pq.isEmpty()){
                char current = pq.remove();
                map.put(current, map.get(current) - 1);
                total++;
                if(map.get(current) <= 0){
                    map.remove(current);
                }
            }
            if(!map.isEmpty()){
                total += n + 1 - size;
            }

        }


        return total;

    }
}
