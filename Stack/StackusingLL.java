public class StackusingLL {
    static class Node{
        int data;
        Node next;
        Node (int data){
            this.data=data;
            this.next=null;
        }
    }
    static class stack {
        static Node head=null;
        public static boolean isEmpty(){
            return head==null;
        }
        public static void push(int data){
            Node newnode=new Node(data);
            if(isEmpty()){
                head=newnode;
            }
            newnode.next=head;
            head=newnode;
        } 
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int data=head.data;
            head=head.next;
            return data;
        }
        public static int peek(){
            if (isEmpty()){
                return -1;
            }
            return head.data;
        }

    } 
    public static void main(String[] args) {
       stack s=new stack();
       s.push(3);
       s.push(6);
       System.out.println(s.isEmpty());
       System.out.println(s.pop());
       System.out.println(s.peek());
    }
}
