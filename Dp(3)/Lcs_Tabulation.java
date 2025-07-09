public class Lcs_Tabulation{
    public static int lcstab(String s1, String s2, int n, int m){
         int [][] dp=new int [n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i <= m; i++) {
                dp[0][i]= 0;  
        } 

       for (int i = 1; i < n+1; i++) {
        for (int j = 1; j < m+1; j++) {
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1] + 1;
            }
            else{
            int ans1= dp[i-1][j];
            int ans2=dp[i][j-1];
            dp[i][j]= Math.max(ans1, ans2);
            }     
        }
      }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1= "abcdge";
        String s2= "abdg";
        int n=s1.length();
        int m= s2.length();
       
        System.out.println("------------------");
        System.out.println(lcstab(s1, s2, n, m));
    }    
}
