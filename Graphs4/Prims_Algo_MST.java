import java.util.*;
public class Prims_Algo_MST {
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

    public static class pair implements Comparable<pair>{
        int n;
        int cost;
        pair(int n , int cost){
            this.n=n;
            this.cost=cost;
        }
        @Override
        public int compareTo(pair p2){
            return this.cost-p2.cost;
        }
    }

    public static void prims(ArrayList<Edge> [] graph){
        boolean [] visited=new boolean[graph.length];
        PriorityQueue<pair> q= new PriorityQueue<>();
        int cost=0;

        q.add(new pair(0, 0));

        while(!q.isEmpty()){
            pair curr= q.remove();
            if(!visited[curr.n]){
                visited[curr.n]=true;
                cost+=curr.cost;
                
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e= graph[curr.n].get(i);
                    q.add(new pair(e.dst, e.wt));  
                }
            }
        }
        System.out.println("Minimum cost of (MST) is: "+ cost);
    }
   
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> [] graph= new ArrayList[v];
        for(int i=0;i<v; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));



        System.out.println("-----------------------------");
        prims(graph);
    } 
    
}
