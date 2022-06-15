public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int total = 0;
        int gindex = 0;
        int sindex = 0;
        while(gindex < g.length && sindex < s.length){
            if(g[gindex] <= s[sindex]){
                gindex++;
                total++;
            }
            sindex++;
        }

        return total;
    }
}
