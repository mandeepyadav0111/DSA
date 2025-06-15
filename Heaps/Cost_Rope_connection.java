import java.util.*;
public class Cost_Rope_connection {

    public static void main(String[] args) {
        int [] arr= {2,3,3,4,6};
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]);
        }

        int cost=0;
        while(pq.size() >1){
            int c1=pq.remove();
            int c2= pq.remove();
            cost+=c1+c2;
            pq.add(c1+c2);
        }
        
        System.out.println("------------------");
        System.out.println("Cost to connect rope is: " + cost);
    }
    
}
