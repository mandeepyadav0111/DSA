import java.util.*;

public class Topological_Sort {
     public static class Edge{
        int src;
        int dst;
        Edge(int s, int d){
            this.src=s;
            this.dst=d;
        }
    }
///////////////
    public static void topsort(ArrayList<Edge> [] graph){
          boolean [] visited=new boolean[graph.length];
          Stack<Integer> st= new Stack<>();
            for (int i = 0; i <graph.length; i++) {
            if(!visited[i]){
               topsortutil(graph, i, visited,st);
               }
            } 
            while(!st.isEmpty()){
                System.out.println(st.pop());
            }
    }
    
    public static void topsortutil(ArrayList<Edge> [] graph,int curr, boolean[] visited,Stack<Integer> st){
           visited[curr]=true;
           for (int i = 0; i < graph[curr].size(); i++) {
               Edge e= graph[curr].get(i);

               if(!visited[e.dst] ){
                topsortutil(graph, e.dst, visited, st);
               }   
           }
           st.push(curr);
    }
//////////////////////
     public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> [] graph= new ArrayList[v];
        for(int i=0;i<v; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge( 2, 3));

        graph[3].add(new Edge(3, 1 ));
        
        graph[4].add(new Edge(4, 0 ));
        graph[4].add(new Edge(4, 1));
      
        graph[5].add(new Edge( 5, 0));
        graph[5].add(new Edge( 5, 2));

        System.out.println("-----------------------------");
        topsort(graph);
       
    } 
    
}
