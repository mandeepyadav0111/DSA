import java.lang.reflect.Array;
import java.util.*;
public class Longst_Increasing_subseq {
    public static int lis(int [] arr){
        HashSet<Integer> set= new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int [] newarr= new int [set.size()];
        int idx=0;
        for(int a : set){
            newarr[idx++]=a;
        }
        Arrays.sort(newarr);

        int [][] dp= new int [arr.length+1][newarr.length+1];
        for (int i = 1; i < arr.length+1; i++) {
            for (int j = 1; j < newarr.length+1; j++) {
                if(arr[i-1] == newarr[j-1]){
                    dp[i][j]=dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                } 
            }
        } 
        return dp[arr.length][newarr.length];
    }

    public static void main(String[] args) {
        int [] arr={50, 3, 10, 7, 40, 80};
        System.out.println("---------------");
        System.out.println(lis(arr));
        
    }
    
}
