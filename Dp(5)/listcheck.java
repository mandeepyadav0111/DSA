import java.util.*;
public class listcheck{
    public static void main(String[] args) {

        System.out.println("----------------");
        ArrayList<Integer> list= new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(2);
        list.add(9);
        int i=0;
        while(!list.isEmpty() && list.size()>i){
            System.out.println(list.get(i++));
        }

//////////////////
        while(list.get(0)==0){
            list.add(list.remove(0));
        }
        int j=0;
        while(!list.isEmpty() && j < list.size()){
            System.out.println(list.get(j++));
        }


    }
}