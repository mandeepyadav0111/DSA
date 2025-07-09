import java.util.*;
public class Mat_C_MMemorization {
    public static int mcmmemo(int [] arr, int i, int j, int [][] dp){
        if(i==j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
           int ans= Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1= mcmmemo(arr, i, k, dp);
            int cost2=mcmmemo(arr, k+1, j, dp);
            int cost3= arr[i-1] * arr[k] * arr[j];
            int finalans= cost1 + cost2 + cost3;
            ans=Math.min(ans, finalans);
        }
        return dp[i][j]=ans;
    }

    public static void main(String[] args) {
        int [] arr= {1,2,3,4,3};
        int n=arr.length;
        int [][] dp= new int [n][n];
        for(int [] a : dp){
            Arrays.fill(a, -1);
        }

        System.out.println("----------------");
        System.out.println(mcmmemo(arr, 1, n-1, dp));
    }
}    
    

