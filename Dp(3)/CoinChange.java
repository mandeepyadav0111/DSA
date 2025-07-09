public class CoinChange {
    public static int coinchange(int [] coins, int target){
        int n=coins.length;
       int [][] dp= new int [n+1][target+1];
        for (int i = 0; i < n+1; i++) {
           dp[i][0]=1; 
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < target+1; j++) {
                int value=coins[i-1];
                if(value <= j){
                    //include
                    dp[i][j]=dp[i][j-value] + dp[i-1][j];
                }
                else  {
                    //exclude
                    dp[i][j]=dp[i-1][j];   
                } 
            }
        }
        return dp[n][target]; 
    }
    public static void main(String[] args) {
        int [] arr= {2,5,3,6};
        int target=10;
        System.out.println("-----------");
        System.out.println(coinchange(arr, target));

    }
    
}
