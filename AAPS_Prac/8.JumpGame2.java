public class JumpGame2 {
    public static int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, maxReach = 0;

        // Don't include the last index, since we want to reach *or pass* it
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currentEnd) { // we must jump
                jumps++;
                currentEnd = maxReach;

                // Optional: If currentEnd already passes the last index, break early
                if (currentEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4}; // Output: 2
        int[] nums2 = {1, 2, 3};       // Output: 2

        System.out.println("Min jumps (case 1): " + jump(nums1));
        System.out.println("Min jumps (case 2): " + jump(nums2));
    }
}
