import java.util.LinkedList;
import java.util.Queue;

public class UsingJavaCOLLECTIONframework {
    public static void main(String[] args) {
    
        Queue<Integer> q= new LinkedList<>();
       
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        System.out.println(q.remove());
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
    
}
