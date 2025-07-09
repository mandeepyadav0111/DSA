public class Wildcard_Matching{
    public static boolean wm(String s, String w){
        int n = s.length();
        int m=w.length();
        boolean [][] dp= new boolean [n+1][m+1];
        dp[0][0]= true;
        for (int i = 1; i < n+1; i++) {
            dp[i][0]= false;
        }
        for (int j = 1; j < m+1; j++) {
            if(w.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }  
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s.charAt(i-1)==w.charAt(j-1) || w.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(w.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1] ||dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s= "abc";
        String w= "**?b*";

        System.out.println("------------------");
        System.out.println(wm(s, w));

    }
}