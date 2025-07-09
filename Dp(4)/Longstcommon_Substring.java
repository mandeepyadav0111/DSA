public class Longstcommon_Substring {
    public static int lcs(String s1, String s2){
        int n=s1.length();
        int m=s2.length();
        int [][] dp = new int [n+1][m+1];
        int ans=0;
        // 0th row and 0th column should be 0 but in java array already initialize with 0
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1] +1; 
                    ans=Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s1="abcdgh";
        String s2="acdghr";
        System.out.println("-------------------");
        System.out.println(lcs(s1, s2));
    }
    
}
