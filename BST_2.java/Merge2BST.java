import java.lang.reflect.Array;
import java.util.*;
public class Merge2BST {
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
    //////////////////////
      public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

/////////////////
     static void inorder(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }
////////////////
    static Node createBST(ArrayList<Integer> arr, int si, int end){
        if(si > end){
            return null;
        }
        int mid= (si+end)/2;
        Node root=new Node(arr.get(mid));
        root.left=createBST(arr, si ,mid-1);
        root.right=createBST(arr,mid+1,end);
        return root;
    }
////////////////
    public static Node merge(Node root1,Node root2){
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        
       inorder(root1,list1);
        inorder(root2, list2);

         ArrayList<Integer> mergedList=new ArrayList<>();
         int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }
        
       Node mergedBst=createBST(mergedList,0, mergedList.size()-1);
       return mergedBst;

    }


    public static void main(String[] args) {
         Node root1=new Node(50);
         root1.left=new Node(30);
         root1.left.left=new Node(20);
         root1.left.left.left=new Node(10);

         Node root2=new Node(60);
         root2.right=new Node(70);
         root2.right.right=new Node(80);

         System.out.println("---------------------");
         Node newroot=merge(root1, root2);
         inorder(newroot);
    }
    
}
