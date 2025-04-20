import java.util.*;

public class Implement {
    public static void main(String[] args) {
        Deque<Integer> dq= new LinkedList <>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(3);
        dq.addLast(4);
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());
        System.out.println(dq);


    }
    
}
