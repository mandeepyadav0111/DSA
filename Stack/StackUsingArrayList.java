import java.util.ArrayList;

public class StackUsingArrayList {
  static class Stack{
       static ArrayList<Integer> List=new ArrayList<>();
        public static boolean isEmpty(){
            return List.size()==0;
        }
        
        public static void push(int data){
            List.add(data);
        } 
        public static int pop(){
            int data=List.get(List.size()-1);
            List.remove(List.size()-1);
            return data;
        }
        public static int peek(){
            return List.get(List.size()-1);
        }
    }
    public static void main(String[] args) {
        Stack s=new Stack();
       System.out.println( s.isEmpty());
    }
}
