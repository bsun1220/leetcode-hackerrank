public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prereq) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            map.put(i, new HashSet<>());
        }

        for(int i = 0; i < prereq.length; i++){
            int courseOne = prereq[i][0];
            int courseTwo = prereq[i][1];
            map.get(courseOne).add(courseTwo);
        }

        int index = 0;
        int [] ret = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i : map.keySet()){
            if(map.get(i).size() == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){

            int curr = q.remove();
            ret[index] = curr;
            index++;
            if(index == numCourses){
                return ret;
            }

            for(int i : map.keySet()){
                if(map.get(i).contains(curr)){
                    map.get(i).remove(curr);
                    if(map.get(i).size() == 0){
                        q.add(i);
                    }
                }
            }
        }

        return new int[0];


    }
}
