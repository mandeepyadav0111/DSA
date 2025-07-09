public class Editdistance {
    public static int editdis(String s1, String s2){
        int n= s1.length();
        int m=s2.length();
        int [][] dp= new int [n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0]= i;
        }
        for (int i = 0; i < m+1; i++) {
            dp[0][i]= i;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {

                if(s1.charAt(i-1)== s2.charAt(j-1)){    //same (do nothing)
                    dp[i][j] = dp[i-1][j-1]; 
                }
                else{                // different
                    int add= dp[i][j-1] +1;
                    int delete= dp[i-1][j] +1;
                    int replace= dp[i-1][j-1] +1;

                    int min12= Math.min(add, delete);
                    dp[i][j]= Math.min(min12, replace);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1= "intention";
        String s2= "execution";

        System.out.println("---------------");
        System.out.println(editdis(s1, s2));
    }
    
}
