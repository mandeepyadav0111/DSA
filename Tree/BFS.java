import java.util.*;

public class BFS{
   
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
    
   public static void main(String[] args) {
       Node root= new Node(1);
       root.left=new Node(2);
       root.right=new Node(3);
       root.left.left=new Node(4);
       root.left.right=new Node(5);
       root.right.right=new Node(6);
       
       System.out.println();
       BFS(root);

   }
}    
        
