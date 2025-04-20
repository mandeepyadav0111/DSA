import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthPairChain {
     public static int findLongestChain(int[][] pairs) {
        int n=pairs.length;
        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
        int count =1;
        int last=pairs[0][1];
        for(int i=1;i<n;i++){
            if(last<pairs[i][0]){
                count++;
                last=pairs[i][1];
            }
        }
        return count;
        
    }
    public static void main(String[] args) {
        int [][]pairs = {{1,2},{2,3},{3,4}};
        System.out.println(findLongestChain( pairs));
    }
    
}
