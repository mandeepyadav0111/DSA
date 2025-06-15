import java.util.ArrayList;
import java.util.Collections;

public class Job_Sequence_max_profit {
    class Job{
        int id;
        int deadline;
        int profit;
        Job(int id,int deadline,int profit){
            this.id=id;
            this.deadline=deadline;
            this.profit=profit;
        }
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n=deadline.length;
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Job> jobs= new ArrayList<>();
        for(int i=0;i<n;i++){
            jobs.add(new Job(i,deadline[i],profit[i]));
        }
        
        Collections.sort(jobs,(a,b)->b.profit-a.profit);
       
        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }

        // Time slots: false = free, true = occupied
        boolean[] slots = new boolean[maxDeadline + 1];  // 1-based indexing
        int count = 0, totalProfit = 0;

        for (Job job : jobs) {
            // Find the latest available slot before or on job.deadline
            for (int j = job.deadline; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    count++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
       ans.add(count);
       ans.add(totalProfit);
       return ans;
    }

    
public static void main(String[] args) {
    int[]deadline = {4, 1, 1, 1};
    int [] profit = {20, 10, 40, 30};
    System.out.println();
    Job_Sequence_max_profit obj = new Job_Sequence_max_profit();
    System.out.println(obj.jobSequencing(deadline, profit));
}
}

