public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        int lastIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // Can't reach this index
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= lastIndex) return true; // Can reach or go beyond last index
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4}; // true
        int[] nums2 = {3, 2, 1, 0, 4}; // false

        System.out.println("Can jump (case 1): " + canJump(nums1));
        System.out.println("Can jump (case 2): " + canJump(nums2));
    }
}





// public class JumpGame {
//     public static boolean canJump(int[] nums) {
//         int maxReach = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (i > maxReach) return false; // Cannot even reach this point
//             maxReach = Math.max(maxReach, i + nums[i]); // Update the furthest reachable index
//         }

//         return true;
//     }

//     public static void main(String[] args) {
//         int[] nums = {2, 3, 1, 1, 4};
//         System.out.println(canJump(nums)); // true
//     }
// }
