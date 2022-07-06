public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        boolean [][] dp = new boolean[s.length()][s.length()];
        int maxend = 0;
        int maxstart = 0;
        for(int end = 0; end < s.length(); end++){
            dp[end][end] = true;
            for(int start = 0; start < end; start++){
                if(s.charAt(start) != s.charAt(end)){
                    continue;
                }
                else if (start + 1 < end - 1 && !dp[start + 1][end - 1]){
                    continue;
                }
                dp[start][end] = true;
                if(end - start > maxend - maxstart){
                    maxend = end;
                    maxstart = start;
                }
            }
        }
        return s.substring(maxstart, maxend + 1);
    }
}
