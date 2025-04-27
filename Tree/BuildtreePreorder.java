import java.util.*;
public class BuildtreePreorder {
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
    public static class Binarytree{ 
        static int idx = -1;
        public static Node buildtree(int[] arr){
            idx++;
            if (arr[idx]==-1){
                return null;
            }
            Node newnode=new Node(arr[idx]);
            newnode.left=buildtree(arr);
            newnode.right=buildtree(arr);
            return newnode;
        }

        public static void traversePREorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            traversePREorder(root.left);
            traversePREorder(root.right);
        }
        public static void traversePOSTorder(Node root){
            if(root==null){
                return;
            }
           
            traversePOSTorder(root.left);
            System.out.print(root.data+" ");
            traversePOSTorder(root.right);
        }
        public static void traverseINorder(Node root){
            if(root==null){
                return;
            }
           
            traverseINorder(root.left);
            System.out.print(root.data+" ");
            traverseINorder(root.right);
        }

        public static void BFS(Node root){
            Queue<Node> q= new LinkedList<>();
            if(root==null){
                return;
            }
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node curr=q.remove();
                if(curr==null){
                    System.out.println(); 
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(curr.data+" ");
                   if(curr.left!=null){
                    q.add(curr.left);
                   }
                   if(curr.right!=null){
                    q.add(curr.right);
                   } 
                    
                }
                
            }
        }
    }

  public static void main(String[] args) {
    int [] arr={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    Binarytree tree=new Binarytree();
    Node root =tree.buildtree(arr);

    System.out.println("root value:"+root.data);

    System.out.println("Preorder traversal:");
    tree.traversePREorder(root);

    System.out.println();
    System.out.println("Preorder traversal");
    tree.traversePOSTorder(root);

    System.out.println();
    System.out.println("Inorder traversal:");
    tree.traverseINorder(root);

    System.out.println();
    System.out.println("BFS traversal:");
    tree.BFS(root);

  }  
}
