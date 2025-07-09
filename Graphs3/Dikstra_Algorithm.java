import java.util.*;

public class Dikstra_Algorithm {
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
        int path;
        pair(int n , int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(pair p2){
            return this.path-p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge> [] graph,int src){
        int [] distance= new int [graph.length];
        boolean [] visited=new boolean[graph.length];
        PriorityQueue<pair> q= new PriorityQueue<>();

        for (int i = 0; i < graph.length; i++) {
            if(i!=src){
                distance[i]=Integer.MAX_VALUE;
            }   
        }
        q.add(new pair(src, 0));

        while(!q.isEmpty()){
            pair curr= q.remove();
            if(!visited[curr.n]){
                visited[curr.n]=true;
                
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e= graph[curr.n].get(i);
                    int u= e.src;
                    int v= e.dst;
                    int wt=e.wt;

                    if(distance[u]+ wt < distance[v]){
                        distance[v]= distance[u]+wt;
                        q.add(new pair(v,distance[v])); 
                    }  
                }
            }
        }
        for(int i=0; i<graph.length; i++){
            System.out.print(distance[i]+" ");
        }
    }
   
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> [] graph= new ArrayList[v];
        for(int i=0;i<v; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));

        System.out.println("-----------------------------");
        int source=0;
        dijkstra(graph, source);
    } 
    
}
