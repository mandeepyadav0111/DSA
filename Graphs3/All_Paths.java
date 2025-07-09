import java.util.*;

public class All_Paths {
     public static class Edge{
        int src;
        int dst;
        Edge(int s, int d){
            this.src=s;
            this.dst=d;
        }
    }
///////////////
 public static void allpath(ArrayList<Edge> [] graph,int src,int dest,String path){
    if(src==dest){
        System.out.println(path+dest);
    }

    for(int i=0; i<graph[src].size(); i++){
        Edge e= graph[src].get(i);
        allpath(graph,e.dst ,dest, path+src); 
    }
 }
 
//////////////////////
     public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> [] graph= new ArrayList[v];
        for(int i=0;i<v; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge( 0, 3));

        graph[2].add(new Edge( 2, 3));

        graph[3].add(new Edge(3, 1 ));
        
        graph[4].add(new Edge(4, 0 ));
        graph[4].add(new Edge(4, 1));
      
        graph[5].add(new Edge( 5, 0));
        graph[5].add(new Edge( 5, 2));

        int src=5; int dest=1;
        System.out.println("-----------------------------");
        allpath(graph,src, dest, "");
       
    } 

    
}
