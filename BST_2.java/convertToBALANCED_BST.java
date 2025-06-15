import java.util.*;
public class convertToBALANCED_BST {
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

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static Node createBST(ArrayList<Integer> list, int si, int end){
        if(si > end){
            return null;
        }
        int mid= (si+end)/2;
        Node root=new Node(list.get(mid));
        root.left=createBST(list, si ,mid-1);
        root.right=createBST(list,mid+1,end);
        return root;
    }

    static void inorder(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }


    static Node Balance(Node root){
       ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);

        root=createBST(list,0,list.size()-1);
        return root;
    }

    public static void main(String[] args) {
        Node root=new Node(9);
        root.left=new Node(8);
        root.left.left=new Node(7);
        root.left.left.left=new Node(6);
        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);

        root=Balance(root);
    
        System.out.println("-----------------------");
        inorder(root);

    }
}
