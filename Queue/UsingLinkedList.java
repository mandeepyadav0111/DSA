public class UsingLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static class Queue{
        static Node head=null;
        static Node tail=null;

        public static boolean isEmpty() {
            return head==null && tail==null;
            
        }

        public static void add(int data) {
            Node newnode=new Node(data);
            if(isEmpty()){
                head=tail= newnode;
            }
            tail.next=newnode;
            tail=tail.next;
        }

        public static int remove(){
            if(isEmpty()){
                return-1;
            }
            int value=head.data;
            if(head==tail){
                head=tail=null;
            }
            else{
                head=head.next;
            }
           return value;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }

    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
    
}
