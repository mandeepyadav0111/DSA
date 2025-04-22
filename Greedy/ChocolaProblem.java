
import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
     static int chocola(Integer [] costvar,Integer [] costhor){
        Arrays.sort(costvar,Collections.reverseOrder());
        Arrays.sort(costhor ,Collections.reverseOrder());

        int cost=0;
        int vpointer=0;
        int hpointer=0;
        int vpiece=1;
        int hpiece=1;
        while(hpointer<costhor.length && vpointer<costvar.length){
            if(costvar[vpointer] <= costhor[hpointer]){
                cost += costhor[hpointer]*vpiece;
                hpointer++;
                hpiece++;

            }
            else{
                cost += costvar[vpointer]*hpiece;
                vpointer++;
                vpiece++;
            }
        }
        while(hpointer < costhor.length){
            cost += costhor[hpointer]*vpiece;
            hpointer++;
            hpiece++;
        }
        while(vpointer < costvar.length){
            cost += costvar[vpointer]*hpiece;
                vpointer++;
                vpiece++;
        }
       
         return cost;
     }
    public static void main(String[] args) {
        Integer [] costhor={4,1,2};
        Integer [] costvar ={2,1,3,1,4};
        // [][][][][][]
        // [][][][][][] chocolate(4x6)
        // [][][][][][]
        // [][][][][][]

         System.out.println("Total minimum cost to cut chocolate is: "+chocola(costvar,costhor));
      
    }
     
}
