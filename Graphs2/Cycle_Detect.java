import java.util.*;
public class Cycle_Detect {
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

      public static boolean detectcycle(ArrayList<Edge> [] graph){
          boolean [] visited=new boolean[graph.length];
            for (int i = 0; i <graph.length; i++) {
            if(!visited[i]){
               if( detectcycleutil(graph,visited,i,-1)){
                return true;
               }
            } 
         }
         return false;
      }
     public static boolean detectcycleutil(ArrayList<Edge> [] graph, boolean[] visited,int curr,int parent){
           visited[curr]=true;
           for (int i = 0; i < graph.length; i++) {
            Edge e= graph[curr].get(i);
            int neighbour=e.dst;
            // case 3: 
                if(!visited[neighbour]){
                    if(detectcycleutil(graph,visited, neighbour, curr)){
                        return true;
                    }
                }
            // case 1:   
                else if(visited[neighbour] && neighbour!= parent){
                    return true;
                }
            // case 2: do nothing:
           }
           return false;
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
        System.out.println(detectcycle(graph));
       
    } 
    
}
