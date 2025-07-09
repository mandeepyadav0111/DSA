import java.util.*;
public class Topological_sort_BFS {
    public static class Edge{
        int src;
        int dst;
        Edge(int s, int d){
            this.src=s;
            this.dst=d;
        }
    }
///////////////
 public static void indegree(ArrayList<Edge> [] graph,int[] arr){
  for (int i = 0; i < graph.length; i++) {
    for(int j=0; j<graph[i].size();j++){
        int idx=graph[i].get(j).dst;
        arr[idx]++;
    }     
  }
 }
 /////////////////
    public static void topsort(ArrayList<Edge> [] graph){
        int []indgree=new int [graph.length];
        indegree(graph,indgree);
        Queue<Integer> q= new LinkedList<>();

        for(int i=0;i<indgree.length; i++){
            if(indgree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int element =q.remove();
            System.out.print(element+ " ");
            for(int i=0; i<graph[element].size();i++){
                Edge e=graph[element].get(i);
                indgree[e.dst]--;
                if(indgree[e.dst]==0){
                    q.add(e.dst);
                }
            }
        }
        
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
