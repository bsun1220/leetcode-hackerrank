public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < asteroids.length; i++){
            int current = asteroids[i];
            boolean isNotErase = true;
            while(!s.isEmpty() && checkCrash(s.peek(), current)){
                int val = s.pop();
                if(Math.abs(current) == Math.abs(val)){
                    isNotErase = false;
                    break;
                }
                else if(Math.abs(val) > Math.abs(current)){
                    current = val;
                }
            }
            if(isNotErase){
                s.push(current);
            }
        }
        while(!s.isEmpty()){
            list.add(0, s.pop());
        }

        int [] ret = new int[list.size()];
        for(int i = 0; i < ret.length; i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    public boolean checkCrash(int one, int two){
        return (one > 0) && (two < 0);
    }
}
