import java.util.*;
public class Delete_Node_BST{
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
    
    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left=delete(root.left,val);
        }
        else if(root.data<val){
            root.right=delete(root.right,val);
        }
        else{
            //case1: Leaf Node
            if(root.right==null && root.left==null){
                return null;
            }
            // case2: one child
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            // case3:Both child
            else{
                Node Is=inorder_successor(root.right);
                   root.data=Is.data;
                   root.right=delete(root.right,Is.data); 
            }
        }
        return root;
    }

    public static Node inorder_successor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
     public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
    Node root=new Node(5);
    root.left=new Node(3);
    root.right=new Node(7);
    root.left.left=new Node(2);
    root.left.right=new Node(4);
    root.right.left=new Node(6);
    root.right.right=new Node(8);
    System.out.println();
    inorder(root);
    delete(root,8);
    System.out.println();
    inorder(root);
  
}
    
}
