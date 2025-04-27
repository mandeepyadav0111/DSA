public class DiameterON {
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

    static class info{
        int diameter;
        int height;
        info(int diameter,int height){
            this.diameter=diameter;
            this.height=height;
        }
    }
    static info diameteroftree(Node root){
        if(root==null){
          return new info(0,0);
        }
        info leftinfo=diameteroftree(root.left);
        info rightinfo=diameteroftree(root.right);

        int diameter= Math.max(Math.max(leftinfo.diameter,rightinfo.diameter),leftinfo.height+rightinfo.height+1);
        int height=Math.max(leftinfo.height,rightinfo.height)+1;
        return new info(diameter,height);

  }
  public static void main(String[] args) {
    Node root= new Node(1);                    //           1
    root.left=new Node(2);                     //          /  \
    root.right=new Node(3);                    //         2    3
    root.left.left=new Node(4);                //       /  \   / \
    root.left.right=new Node(5);               //      4   5   6  7
    root.right.left=new Node(6);               
    root.right.right=new Node(7);  
                
    System.out.println();
    info result= diameteroftree(root);
    System.out.println("Diameter of tree is:"+result.diameter +"and Height of tree is:"+result.height);
    
  }
}
