public class Matrix_Chain_Multiplication {
    public static int mcm(int [] arr, int i, int j){
        if(i==j){ // single matrix;
            return 0;
        }

        int ans= Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1= mcm(arr, i, k);
            int cost2=mcm(arr, k+1, j);
            int cost3= arr[i-1] * arr[k] * arr[j];
            int finalans= cost1 + cost2 + cost3;
            ans=Math.min(ans, finalans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr= {1,2,3,4,3};
        int n=arr.length;

        System.out.println("----------------");
        System.out.println(mcm(arr, 1, n-1));
    }
    
}
