import java.util.*;
public class ClimbingStairs_memorization {
    public static int memorizationstairs(int n, int []ways){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(ways[n] != -1){
            return ways[n];
        }
        ways[n] = memorizationstairs(n-1, ways) + memorizationstairs(n-2, ways);
        return ways[n];
    }
    public static void main(String[] args) {
        int n=5;
        int [] ways=new int [n+1];
        Arrays.fill(ways, -1);
        System.out.println("------------------------");
        System.out.println(memorizationstairs(n, ways));
    }
    
}
