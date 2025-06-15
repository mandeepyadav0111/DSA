import java.rmi.StubNotFoundException;
import java.util.*;
public class LRU_PageReplacement {
    public static void main(String[] args) {
        int capacity=3;
        int [] pages={1,2,3,4,2,1,5,2,3,4,5};
        Set<Integer> memory=new HashSet<>();
        Map<Integer,Integer> recentuse=new HashMap<>();

        int pagefault=0;
        for(int i=0;i<pages.length;i++){
            int page=pages[i];
            if(!memory.contains(page)){
                pagefault++;
                if(memory.size()==capacity){
                    int lrupage =-1 ,lruIndex=Integer.MAX_VALUE;
                    for(int p: memory){
                        int lastUsed=recentuse.get(p);
                        if(lastUsed < lruIndex){
                            lruIndex=lastUsed;
                            lrupage=p;
                        }
                    }
                    memory.remove(lrupage);
                    recentuse.remove(lrupage);
                    System.out.println("Removed LRU page: "+ lrupage);
                }
                memory.add(page);
                System.out.println("Page "+page+" assessed from memory.");
                
            }
            else{
                System.out.println("page "+page+" assesed from memory.");
            }
            recentuse.put(page,i);
        }
        System.out.println("Total page faults: " +pagefault);

    }
    
}
