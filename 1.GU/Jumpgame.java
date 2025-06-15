public class Jumpgame{
    public static boolean canjump(int [] nums){
        int maxreach=0;
        int lastindex=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(i>maxreach){
                return false;
            }
            maxreach=Math.max(maxreach,nums[i]+i);
        }
        return true;
    }

    public static void main(String[] args) {
        int [] nums1={2,3,1,1,4};
        int [] nums2={3,2,1,0,4};

        System.out.println("---------------------------------");
        System.out.println("Can Jump: "+canjump(nums1));
        System.out.println("Can Jump: "+canjump(nums2));
        
    }

}
