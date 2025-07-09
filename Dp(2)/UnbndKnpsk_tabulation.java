public class UnbndKnpsk_tabulation {
     public static int knpsack(int [] val, int [] wt, int w){
        int n=val.length;
        int [][] dp= new int [n+1][w+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < w+1; i++) {
            dp[0][i]=0;
        }
        
             // i, j start from 1 //
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                int weight=wt[i-1];
                int value=val[i-1];

                if(weight <= j){                                 //VALID
                                        // ?***?
                    int include= value + dp[i][j-weight];               //include
                                        // ?***?
                    int exclude= dp[i-1][j];                    //exclude

                     dp[i][j]=Math.max(include, exclude);
                }
                else{ //INVALID
                    int exclude= dp[i-1][j];
                     dp[i][j]=exclude;
                } 
            }  
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int w=7;
        int[] val= {15, 14, 10, 45, 30};
        int [] wt = {2,5,1,3,4};
        
        System.out.println("-------------");
        System.out.println(knpsack(val, wt, w));
    }    
    
}
