public class HouseRobber {
    static  public int rob(int[] nums) {
        int n= nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];

        int[] dp=new int [n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],dp[0]);
        for(int i=2;i<n;i++){
            dp[i]= Math.max(nums[i]+dp[i-2] , dp[i-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int [] nums={2,7,9,3,1};
        System.out.println("----------------------");
        System.out.println(rob(nums));
    }
    
}
