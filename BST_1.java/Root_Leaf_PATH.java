import java.util.*;
public class Root_Leaf_PATH {
     public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            }
    }
      public static void print(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println("");
      }

    public static void roottoleaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            print(path);
        }
        roottoleaf(root.left,path);
        roottoleaf(root.right,path);
        path.remove(path.size()-1);
       
    }
 public static void main(String[] args) {
    Node root=new Node(5);
    root.left=new Node(3);
    root.right=new Node(7);
    root.left.left=new Node(2);
    root.left.right=new Node(4);
    root.right.left=new Node(6);
    root.right.right=new Node(8);
     ArrayList<Integer> path=new ArrayList<>();
     roottoleaf(root,path);
}
}

