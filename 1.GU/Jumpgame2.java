public class Jumpgame2 {
    public static int jump(int[] nums) {
       int maxreach=0;
       int lastindex=nums.length-1;
       int jumps=0 , currentEnd=0;

       for(int i=0;i<nums.length-1;i++){
        maxreach=Math.max(maxreach,i+nums[i]);
        if(i==currentEnd){
            jumps++;
            currentEnd=maxreach;
            
            if(currentEnd>=lastindex){
                break;
            }
       }
       }
       return jumps;
    }

    public static void main(String[] args) {
        int [] nums1={2,3,1,1,4};
        System.out.println("----------------------------------");
        System.out.println("No of jups: "+jump(nums1));
    }
    
}
