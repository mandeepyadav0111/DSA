import java.util.Arrays;

public class MinPlatforms{
    public static int findPlatform(int[] arrival, int[] departure) {
        int n = arrival.length;

        // Sort both arrival and departure times
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platforms = 1, maxPlatforms = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platforms++; // New train has arrived before the previous one left
                i++;
            } else {
                platforms--; // Train has departed, platform freed
                j++;
            }

            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

        int result = findPlatform(arrival, departure);
        System.out.println("Minimum number of platforms required: " + result);
    }
}
