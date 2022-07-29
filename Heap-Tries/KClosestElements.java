public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> Math.abs(a - x) == Math.abs(b - x) ? Integer.compare(b, a) :
                        Integer.compare(Math.abs(b - x), Math.abs(a - x))
        );
        for(int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                pq.remove();
            }
        }
        List<Integer> list = new ArrayList<>(pq);
        Collections.sort(list);

        return list;
    }
}
