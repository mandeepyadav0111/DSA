public class Memorization_01Knap {
    public static int knap(int [] val, int [] wt, int w, int n, int [][]dp){
        if(w==0 || n==0){
            return 0;
        }
        if(dp[n][w]!= -1){
            return dp[n][w];
        }

        if(wt[n-1]<= w){   //VALID
            //include
            int include=val[n-1] + knap(val, wt , w-wt[n-1], n-1, dp);
            //exclude
            int exclude=knap(val, wt, w, n-1, dp);
            dp[n][w]=Math.max(include,exclude);
            return dp[n][w];
        }
        else{    //UNVALID
            dp[n][w]= knap(val,wt, w, n-1, dp);
            return dp[n][w];
        }
    }   
    public static void main(String[] args) {
        int n=5;
        int w=7;
        int[] val= {15, 14, 10, 45, 30};
        int [] wt = {2,5,1,3,4};
        int [][] dp= new int[n+1][w+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=w; j++) {
                dp[i][j]=-1;
            }  
        }
        
        System.out.println("---------------");
        System.out.println(knap(val, wt, 7, n, dp));
    }

    
}
