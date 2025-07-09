import java.util.*;
public class Bellman_Ford_Algo {
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


    public static void bellman(ArrayList<Edge> [] graph,int src){
        int [] distance= new int [graph.length];
    
        for (int i = 0; i < graph.length; i++) {
            if(i!=src){
                distance[i]=Integer.MAX_VALUE;
            }   
        }
       

        int vt=graph.length;
        for (int i = 0; i < vt-1; i++) {

            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[i].size(); k++) {
                    Edge e= graph[i].get(k);
                    int u= e.src;
                    int v= e.dst;
                    int wt=e.wt;

                    if(distance[u]+ wt < distance[v]){
                        distance[v]= distance[u]+wt; 
                    }  
                }
            }
        }        
        for(int i=0; i<graph.length; i++){
            System.out.print(distance[i]+" ");
        }     graph[1].add(new Edge(1, 0, 5));
    }
       
   
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> [] graph= new ArrayList[v];
        for(int i=0;i<v; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

        System.out.println("-----------------------------");
        int source=0;
        bellman(graph, source);
    } 
}    

