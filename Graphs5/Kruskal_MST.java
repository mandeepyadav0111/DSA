import com.sun.security.jgss.ExtendedGSSContext;
import java.util.*;

public class Kruskal_MST {
    public static class Edge implements Comparable<Edge>{
        int src;
        int dst;
        int wt;
        Edge(int s, int d, int wt){
            this.src=s;
            this.dst=d;
            this.wt=wt;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt-e2.wt;
        }
    }

    public static void creategraph(ArrayList<Edge> edges){
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }
 
    static int n=7;
    static int [] parent= new int [n];
    static int [] rank = new int [n];

    public static void init(){
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
    }

    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent [x];
    }

    public static void union(int a, int b){
        int parA=find(a); 
        int parB= find(b);
        if(rank[parA ]>= rank[parB]){
            parent[parB]=parA;
            rank[parA]++;
        }
        else{
            parent[parA]= parB;
            rank[parB]++;
        }
    }
///////////
    public static void kruskal(ArrayList<Edge> edges, int v){
        init();
        Collections.sort(edges);
        int mstcost=0;
        int count =0;

        for(int i=0; count<v-1; i++){      
            Edge e=edges.get(i);     
            int parA=find(e.src);     //parent of src
            int parB= find(e.dst);    //parent of dst
            
            if(parA!=parB){        //no cycle formation
                union(e.src, e.dst);
                mstcost+=e.wt;
                count++;
            }
        }
        System.out.println("cost of MST (Kruskal) is : "+mstcost);
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> edges=new ArrayList<>();
        creategraph(edges);

        System.out.println("--------------------- ");
        kruskal(edges, v);

    }
    
}
