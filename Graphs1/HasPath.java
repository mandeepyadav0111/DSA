import java.util.ArrayList;

public class HasPath {
    
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

    public static boolean haspath(ArrayList<Edge> [] graph,int src, int dst,boolean[] visited){
             if(src==dst){
                 return true;
             }
             visited[src]=true;

            for (int i = 0; i < graph[src].size(); i++) {
                 Edge e= graph[src].get(i);
                 if(!visited[e.dst] && haspath(graph, e.dst, dst, visited)){
                    return true;
                 }
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
        boolean [] visited=new boolean[graph.length];
        System.out.println(haspath(graph, 0,4, visited));
        
    } 
}
