import java.util.*;
public class Cheapest_Flight_Kstops {
      public static class Edge{
        int src;
        int dst;
        int wt;
        Edge(int s, int d, int w){
            this.src=s;
            this.dst=d;
            this.wt=w;
        }
    }

    public static class pair {
        int n;
        int cost;
        int stops;
        pair(int n , int c, int s){
            this.n=n;
            this.cost=c;
            this.stops=s;
        }
    }

    public static int  cheapestflight(int n, int [][] flight,int src,int destination, int k){
        //creating graph
         ArrayList<Edge> [] graph= new ArrayList[n];
        for(int i=0;i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flight.length; i++) {
            int sr= flight[i][0];
            int dst=flight[i][1];
            int wt=flight[i][2];
            Edge e= new Edge(sr, dst, wt);
    
            graph[sr].add(e);
        }
        
        int [] distance= new int [n];
        Queue<pair> q= new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if(i!=src){
                distance[i]=Integer.MAX_VALUE;
            }   
        }
        q.add(new pair(0, 0,0));

        while(!q.isEmpty()){
            pair curr= q.remove();
            if(curr.stops > k){
                break;
            }
               
            for (int i = 0; i < graph[curr.n].size(); i++) {
                Edge e= graph[curr.n].get(i);
                int u= e.src;
                int v= e.dst;
                int wt=e.wt;
                if(curr.cost+ wt < distance[v] && curr.stops<=k){
                    distance[v]= distance[u]+wt;
                    q.add(new pair(v,distance[v], curr.stops+1)); 
                }  
            }
        }
        if(distance[destination]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return distance[destination];
        }
       
    }
   
    public static void main(String[] args) {
       int [][] flight= {{0,1,100}, {1,2,100},{2,0,100}, {1,3,600}, {2,3,200}};

        int source=0;
        int destination=3;
        int k=1;
        System.out.println("-----------------------------");
        System.out.println("Minimum cost of flight with maximum  "+k+ "stops is : "+cheapestflight(4, flight, source,destination , k));


    } 
    
}
