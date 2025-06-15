import java.util.*;
public class BFS_Graph {
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

    public static void bfs(ArrayList<Edge> [] graph){
        Queue<Integer> q=new LinkedList<>();
        boolean [] visited=new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()){
            int curr=q.remove();

            if(!visited[curr]){
                visited[curr]=true;
                 System.out.print(curr+" ");

                 for (int i = 0; i < graph[curr].size(); i++) {
                     Edge e= graph[curr].get(i);
                     q.add(e.dst); 
            }
            }
           
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
        bfs(graph);
    }   
}
