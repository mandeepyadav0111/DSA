import java.util.*;
public class MinSumAbsoluteDiff {
    static long findMinSum(int[] A,int[] B,int N) { 
        Arrays.sort(A);
        Arrays.sort(B);
        long dif=0;
        for(int i=0;i<N;i++){
            dif+=Math.abs(A[i]-B[i]);
        }
        return dif;
    }
    public static void main(String[] args) {
        int [] A = {4,1,8,7};
       int [] B = {2,3,6,5};
       int N=A.length;
       System.out.println(findMinSum(A, B,N));
    }    
}
