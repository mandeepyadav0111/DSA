class Frogjump{
    // Frog can jump 1 or 2 step at a time
    //Energy cosummed in jum is Math.abs(jumping from-jumping to)
    // Our aim is to minimise the energy
    static int jump(int [] height){
        int n=height.length;
        int dp[]= new int [n];
        dp[0]=0;

        if(n>1){
            dp[1]=Math.abs(height[1]-height[0]);
        }
        for(int i=2;i<n;i++){
            int jump1=Math.abs(height[i]-height[i-1])+dp[i-1];
            int jump2=Math.abs(height[i]-height[i-2]) + dp[i-2];
            dp[i]=Math.min(jump1, jump2);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int [] stones={10,30,40,20};
        int result=jump(stones);
        System.out.println("-------------");
        System.out.println("Minimum Energy Required: "+ result);
    }

}