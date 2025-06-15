
import java.util.*;

public class Insert_Intervals {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        while(i<n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        result.add(newInterval);
        while(i<n){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
        
    }

    public static void main(String[] args) {
            int[][] intervals={{1,2},{3,5},{6,7},{8,10},{12,16}};
            int [] newInterval={4,8};

            System.out.println("---------------------------------------");
            int [][] ans=insert(intervals,newInterval);

            for(int i=0; i<ans.length;i++){
                for(int j=0;j<ans[0].length;j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println(" ");
            }
    }
}
