public class SpaceStation {
    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int max = Math.max(c[0], n - 1 - c[c.length - 1]);
        for(int i = 0; i < c.length - 1; i++){
            int front = c[i];
            int back = c[i + 1];
            int change = (back + front)/2;
            int distance = Math.min(change - c[i], back - change);
            max = Math.max(distance, max);
        }
        return max;
    }
}
