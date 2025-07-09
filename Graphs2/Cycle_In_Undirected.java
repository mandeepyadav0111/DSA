import java.util.*;

public class Cycle_In_Undirected{
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
          boolean [] stack= new boolean[graph.length];
            for (int i = 0; i <graph.length; i++) {
            if(!visited[i]){
               if( detectcycleutil(graph,i,visited, stack)){
                return true;
               }
            } 
         }
         return false;
      }
     public static boolean detectcycleutil(ArrayList<Edge> [] graph,int curr, boolean[] visited, boolean [] stack){
           visited[curr]=true;
           stack[curr]= true;
           for (int i = 0; i < graph.length; i++) {
               Edge e= graph[curr].get(i);
              // int neighbour=e.dst;
               if(stack[e.dst]){
                return true;
               }

               if(!visited[e.dst] && detectcycleutil(graph,e.dst, visited,stack)){
                return true;
               }
           
           }
           stack[curr]=false;
           return false;
    }
   
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> [] graph= new ArrayList[v];
        for(int i=0;i<v; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
       graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3,0, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));

        System.out.println("-----------------------------");
        System.out.println(detectcycle(graph));
       
    } 

}