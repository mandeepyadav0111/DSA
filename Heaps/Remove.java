import java.util.ArrayList;

public class Remove {
   static class Heap{
        ArrayList<Integer> arr= new ArrayList<>();
        public boolean isEmpty(){
            return arr.size()==0;
        }
        public int peek(){
            return arr.get(0);
        }

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

        //HEAPIFYYYYY
        public void heapify(int i){
            int minidx=i;
            int left= (i*2)+1;
            int right=(i*2)+2;

            // finding minimum of index i, left, right
            if(left< arr.size() && arr.get(minidx)> arr.get(left)){
                minidx=left;
            }
            if(right< arr.size() && arr.get(minidx)> arr.get(right)){
                minidx=right;
            }

            // if needed swap values of idx with minimum of(i, left, right)
            if(minidx!= i){
                int temp= arr.get(i);
                arr.set(i, arr.get(minidx));
                arr.set(minidx, temp);
                //call heapify for manipulated idx
                heapify(minidx);
            }
        }
        

        public int remove(){
            if (isEmpty()) return -1; // or throw exception

             int data = arr.get(0);

            // move last element to root
            int temp = arr.get(arr.size() - 1);
            arr.set(0, temp);
            arr.remove(arr.size() - 1);

            //HEAPIFY
            heapify(0);
            return data;
        }
    }


    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(5);
        h.add(6);
        h.add(4);
        h.add(3);
        h.add(1);

        System.out.println("----------------------------");
         while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }

    }
    
}
