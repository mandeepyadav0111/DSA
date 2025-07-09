public class Disjoint_Set {
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
    public static void main(String[] args) {
        System.out.println("-------------------");
        init();
        union(1,3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
    }
    
}
