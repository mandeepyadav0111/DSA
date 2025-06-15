public class Largest_BST {
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

static class info{
    boolean isbst;
    int size,min,max;
    info(boolean isbst, int size, int min, int max){
        this.isbst=isbst;
        this.size=size;
        this.min=min;
        this.max=max;
    }
}

public static int maxBst=0;             //8888%%%%%%%%%*********8888888
public static info largestBst(Node root){
    if(root==null){
        return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    info leftinfo=largestBst(root.left);
    info rightinfo=largestBst(root.right);
    int size=leftinfo.size+ rightinfo.size+ 1;
    int max=Math.max(root.data,Math.max(leftinfo.max,rightinfo.max));
    int min=Math.min(root.data,Math.min(leftinfo.min, rightinfo.min));

    if(root.data<=leftinfo.max || root.data>=rightinfo.min){
        return new info(false, size,min ,max);
    }

    if(leftinfo.isbst && rightinfo.isbst){
         maxBst=Math.max(maxBst, size);
        return new info(true,size,min,max);
    }
    return new info(false, size,min,max);
}

public static void main(String[] args) {
    Node root=new Node(50);
    root.left=new Node(30);
    root.left.left=new Node(5);
    root.left.right=new Node(20);

    root.right=new Node(60);
    root.right.left=new Node(45);
    root.right.right=new Node(70);

    root.right.right.left=new Node(65);
    root.right.right.right=new Node(80);

    info result=largestBst(root);
    System.out.println("-----------------");
    System.out.println(maxBst);

}
    
}
