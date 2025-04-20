import java.util.*;
public class Interleave2Queue {
    public static Queue<Integer> Interleave(Queue<Integer> q1 ) {
        Queue<Integer> q2= new LinkedList<>();
        int n=q1.size()/2;

       for (int i=0; i<n; i++) {
           q2.add(q1.remove());
       }
       for (int i=0; i<n; i++) {
           q1.add(q2.remove());
           q1.add(q1.remove());
       }
       return q1;
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println(q);
        System.out.println(Interleave(q));
    }
}
