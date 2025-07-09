public class Lcs_memorization {
     public static int lcsmemo(String s1, String s2, int n, int m, int [][] dp){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        else if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m]= lcsmemo(s1, s2, n-1, m-1, dp) +1 ;
        }
        else{
            int ans1= lcsmemo(s1, s2, n-1, m, dp);
            int ans2=lcsmemo(s1, s2, n, m-1, dp);
            return dp[n][m]= Math.max(ans1, ans2);
        }
    }
    public static void main(String[] args) {
        String s1= "abcdge";
        String s2= "abdg";
        int n=s1.length();
        int m= s2.length();
        int [][] dp=new int [n+1][m+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j]= -1;  
            }  
        }
        System.out.println("------------------");
        System.out.println(lcsmemo(s1, s2, n, m,dp));
    }
    
}
