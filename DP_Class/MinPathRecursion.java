public class MinPathRecursion {
    static int[][]cost={
         {1,3,1},
         {1,5,1},
         {4,2,1}
    };
    static int[][] dp=new int[3][3];

    static int solve(int i, int j){
        if(i==0 &&j==0){
            return cost[0][0];
        }
        if(i<0 ||j<0){
            return Integer.MAX_VALUE;
        }

        int left=solve(i-1,j);
        int top=solve(i,j-1);
        dp[i][j]=cost[i][j] + Math.min(left,top);
        return dp[i][j];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for(int j=0; j<3; j++){
                dp[i][j]=-1;
            }   
        }

        int mincost=solve(2,2);
         System.out.println("---------------------");
        System.out.println(mincost);
    }

    
}
