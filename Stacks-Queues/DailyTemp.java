public class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int [temperatures.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            int current = temperatures[i];
            while(!s.isEmpty() && temperatures[s.peek()] < current){
                int key = s.pop();
                ret[key] = i - key;
            }
            s.push(i);
        }


        return ret;
    }
}
