import java.util.ArrayList;

class Minimum_Dist_btw_two_Nodes{
  static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            }
    }

    public static Node Lca2(Node root , int n1,int n2){
        if(root==null || root.data==n1 || root.data==n2 ){
            return root;
        }
        Node leftlca=Lca2(root.left,n1,n2);
        Node rightlca=Lca2(root.right,n1,n2);

        if(leftlca==null && rightlca==null){
            return null;
        }
        if(leftlca==null){
            return rightlca;
        }
        if(rightlca==null){
            return leftlca;
        }
        
        return root;
    }
   ///////////////////////////////////////////////////
     public static int distance(Node root,int n){
       if(root==null){
        return -1;
       }
       if(root.data==n){
        return 0;
       }
       
       int leftdist=distance(root.left,n);
       int rightdist=distance(root.right,n);

       if(leftdist==-1 && rightdist==-1){
        return -1;
       }
       else if(leftdist==-1){
        return rightdist+1;
       }
       else{
        return leftdist+1;
       }
     }

    public static int mindist(Node root, int n1,int n2){
        Node lca=Lca2(root, n1,n2);
        int dist1=distance(lca , n1);
        int dist2=distance(lca,n2);
        return dist1+dist2;
    }

////////////////////////////////////////////////////////////////
     public static void main(String[] args) {
        Node root= new Node(1);                    //           1
        root.left=new Node(2);                     //          /  \
        root.right=new Node(3);                    //         2    3
        root.left.left=new Node(4);                //       /  \   / \
        root.left.right=new Node(5);               //      4   5   6  7
        root.right.left=new Node(6);               
        root.right.right=new Node(7);              
        
        int n1=7;
        int n2=4;
        System.out.println();
        System.out.println(Lca2(root,n1,n2).data);

        System.out.println("+++++++");
        System.out.println(mindist(root,4,7));
        
    }
    
}