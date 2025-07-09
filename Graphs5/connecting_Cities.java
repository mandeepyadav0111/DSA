import java.util.*;

public class connecting_Cities {
    public static class Edge implements Comparable<Edge>{
        int dst;
        int cost;
        Edge( int d, int w){
            this.dst=d;
            this.cost=w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.cost-e2.cost;
        }
    }

    public static void connectcities(int [][] cities){
        boolean [] visited=new boolean[cities.length];
        PriorityQueue<Edge> q= new PriorityQueue<>();
        int totalcost=0;

        q.add(new Edge(0, 0));

        while(!q.isEmpty()){
           Edge curr= q.remove();
            if(!visited[curr.dst]){
                visited[curr.dst]=true;
                totalcost+=curr.cost;
                
                for (int i = 0; i < cities[curr.dst].length; i++) {
                    if(cities[curr.dst][i] !=0){
                        // Edge e= cities[curr.dst][i];
                        q.add(new Edge(i, cities[curr.dst][i])); 
                    }  
                }
            }
        }
        System.out.println("Minimum cost of (MST) is: "+ totalcost);
    }
   
    public static void main(String[] args) {
       int [][] cities ={{0,1,2,3,4},
                         {1,0,5,0,7},
                         {2,5,0,6,0},
                         {3,0,6,0,0},
                         {4,7,0,0,0}};



        System.out.println("-----------------------------");
        connectcities(cities);
    } 
    
}
