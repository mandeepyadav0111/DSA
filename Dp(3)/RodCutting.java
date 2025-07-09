public class RodCutting {
    //EXACTLY SAME as unbounded knapsack 
     public static int knpsack(int [] val, int [] length, int rodlength){
        int n=val.length;
        int [][] dp= new int [n+1][rodlength+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < rodlength+1; i++) {
            dp[0][i]=0;
        }
        
             // i, j start from 1 //
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < rodlength+1; j++) {
                int len=length[i-1];
                int value=val[i-1];

                if(len <= j){                                 //VALID
                                        // ?***?
                    int include= value + dp[i][j-len];               //include
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
        return dp[n][rodlength];
    }

    public static void main(String[] args) {
        int rodlength=8;
        int[] val= {1,5,8,9,10,17,17,20};
        int [] length = {1,2,3,4,5,6,7,8};
        
        System.out.println("-------------");
        System.out.println(knpsack(val, length, rodlength));
    } 
    
}
