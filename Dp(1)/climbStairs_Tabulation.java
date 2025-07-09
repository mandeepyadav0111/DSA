public class climbStairs_Tabulation {
    public static int stTab(int n){
        if(n<=1){
            return 1;
        }
        int []ways= new int [n];
        ways[0]=1;
        ways[1]=2;
        for(int i=2; i<n; i++){
            ways[i]=ways[i-1]+ways[i-2];
        }
        return ways[n-1];
    }
    public static void main(String[] args) {
        System.out.println("---------------------");
        System.out.println(stTab(5));
    }
    
}
