
public class Knapsack01_Recursion {
    public static int knap(int [] val, int [] wt, int w, int n){
        if(w==0 || n==0){
            return 0;
        }

        if(wt[n-1]<= w){   //VALID
            //include
            int include=val[n-1] + knap(val, wt , w-wt[n-1], n-1);
            //exclude
            int exclude=knap(val, wt, w, n-1);
            return Math.max(include,exclude);
        }
        else{    //UNVALID
            return knap(val,wt, w, n-1);
        }
    }   
    public static void main(String[] args) {
        int[] val= {15, 14, 10, 45, 30};
        int [] wt = {2,5,1,3,4};
        System.out.println("---------------");
        System.out.println(knap(val, wt, 7, 5));
    }
}
