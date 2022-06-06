public class RotateLeft {
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        d = d % a.size();
        List<Integer> list = new ArrayList<>();
        for(int i = d; i < a.size(); i++){
            list.add(a.get(i));
        }
        for(int i = 0; i < d; i++){
            list.add(a.get(i));
        }
        return list;

    }
}
