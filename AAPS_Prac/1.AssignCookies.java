import java.util.*;

public class AssignCookies {
    public static void main(String[] args) {
        int[] greed = {1, 2, 3, 4, 5, 6, 7, 8};      // Children's greed factors
        int[] cookies = {1, 1, 2, 3, 4, 6, 8, 9};  

        Arrays.sort(greed);
        Arrays.sort(cookies);

        int i = 0, j = 0;
        while (i < greed.length && j < cookies.length) {
            if (cookies[j] >= greed[i]) {
                i++; // Child satisfied
            }
            j++; // Try next cookie
        }

        System.out.println("Number of satisfied children: " + i);
    }
}
