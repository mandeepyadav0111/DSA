import java.util.*;

public class JobSequencing {
    public static void main(String[] args) {
        // Each job: {profit, deadline, id}
        List<int[]> jobs = new ArrayList<>();
        jobs.add(new int[]{201, 5, 1});
        jobs.add(new int[]{181, 3, 2});
        jobs.add(new int[]{191, 3, 3});
        jobs.add(new int[]{301, 2, 4});
        jobs.add(new int[]{121, 4, 5});
        jobs.add(new int[]{101, 2, 6});

        // Step 1: Sort jobs by profit descending
        jobs.sort((a, b) -> Integer.compare(b[0], a[0]));

        // Find max deadline to size the time slots array
        int maxDeadline = 0;
        for (int[] job : jobs) {
            if (job[1] > maxDeadline) {
                maxDeadline = job[1];
            }
        }

        // Step 2: Create a schedule array to store job ids, initialize with -1 (empty)
        int[] schedule = new int[maxDeadline + 1]; // using 1-based indexing for convenience
        Arrays.fill(schedule, -1);

        int totalProfit = 0;
        int count = 0;

        // Step 3: Iterate over jobs and assign slots
        for (int[] job : jobs) {
            int profit = job[0];
            int deadline = job[1];
            int id = job[2];

            // Place the job in the latest possible free slot before or on its deadline
            for (int slot = deadline; slot > 0; slot--) {
                if (schedule[slot] == -1) { // empty slot found
                    schedule[slot] = id;
                    totalProfit += profit;
                    count++;
                    break;
                }
            }
        }

        // Step 4: Print scheduled jobs and total profit
        System.out.println("Scheduled Jobs (by time slot):");
        for (int i = 1; i <= maxDeadline; i++) {
            if (schedule[i] != -1) {
                System.out.print("J" + schedule[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
        System.out.println("No. of jobs: " + count);
    }
}
