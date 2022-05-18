public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int [] degree  = new int [numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int [] e : prerequisites){
            int prereq = e[1];
            int post = e[0];
            graph[prereq].add(post);
            degree[post]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int curr = q.remove();
            count++;
            for(int k : graph[curr]){
                degree[k]--;
                if(degree[k] == 0){
                    q.add(k);
                }
            }
        }
        return count == numCourses;


    }
}
