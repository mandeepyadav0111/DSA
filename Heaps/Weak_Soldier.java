
import java.security.cert.PKIXBuilderParameters;
import java.util.PriorityQueue;

public class Weak_Soldier {
    static class Row implements Comparable<Row>{
        int soldier;
        int idx;
        Row(int idx, int soldier){
            this.idx=idx;
            this.soldier=soldier; 
        }
        @Override
        public int compareTo(Row r2){
            if(this.soldier==r2.soldier){
                return this.idx-r2.idx;
            }
            else{
                return this.soldier-r2.soldier;
            }
        }


    }
    public static void main(String[] args) {
        PriorityQueue<Row> pq= new PriorityQueue<>();

        int [][] army={
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}
        };
        

        for (int i = 0; i < army.length; i++) {
            int count=0;
            for (int j = 0; j < army[0].length; j++) {
               count+= army[i][j]==1 ?1 :0 ;
            }
            pq.add(new Row(i,count));
        }

        int k=2;
        System.out.println("-------------------");
        for (int i = 0; i <k; i++) {
            System.out.println("R"+pq.remove().idx);   
        }
        
    }
    
}
