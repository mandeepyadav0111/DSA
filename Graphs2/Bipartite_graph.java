import java.util.*;

public class Bipartite_graph {
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

      public static boolean bipartite(ArrayList<Edge> [] graph){
          int [] color=new int [graph.length];
          for (int i = 0; i < color.length; i++) {
            color[i]=-1;   // no color
          }
          Queue <Integer> q= new LinkedList<>();  // to traverse bfs
            for (int i = 0; i <graph.length; i++) {
            if(color[i]==-1){
              q.add(i);
              color[i]=0;
              while(!q.isEmpty()){   // bfs
                int curr=q.remove();
                for(int j=0; j<graph[curr].size();j++){
                     Edge e=graph[curr].get(j);
                     if(color[e.dst]==-1){      //case 1: no color
                        int nextcolor=color[curr] ==0 ?1 :0;
                        color[e.dst]=nextcolor;
                        q.add(e.dst);
                     }
                     else if(color[e.dst]==color[curr]){
                        return false;
                     }
                }
                
              }
            } 
         }
         return true;
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
        System.out.println(bipartite(graph));
       
       
    } 
    
}
