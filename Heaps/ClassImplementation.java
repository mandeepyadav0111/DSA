import java.util.*;
public class ClassImplementation {
    static class Student implements Comparable<Student>{
        String name;
        int marks;
        Student(String name, int marks){
            this.name=name;
            this.marks=marks;
        }

        @Override
        public int compareTo(Student s2){
            return this.marks-s2.marks;
        }
    }

    public static void main(String[] args){
        PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("a", 30));
        pq.add(new Student("b", 50));
        pq.add(new Student("d", 20));
        pq.add(new Student("c", 70));
        pq.add(new Student("e", 60));

          System.out.println("---------------------------------");
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name +"-->>" + pq.peek().marks);
            pq.remove();
        }

    }


}
