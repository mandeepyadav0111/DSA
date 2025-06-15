import java.util.*;
public class Additem_ArrList_Minheap {
    class Heap{
        ArrayList<Integer> arr= new ArrayList<>();
        
        public void add(int data){
            //add item at last
            arr.add(data);

            int idx=arr.size()-1;
            int pridx= (idx-1)/2;

            while(arr.get(idx)< arr.get(pridx)){
                int temp=arr.get(idx);

                arr.set(idx, arr.get(pridx));
                arr.set(pridx,temp);

                idx=pridx;
                pridx=(idx-1)/2;
            }
        }
    }
    
}
