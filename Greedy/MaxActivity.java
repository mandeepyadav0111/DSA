import java.util.ArrayList;

public class MaxActivity {
    public static void main(String[] args) {
        int []start={1,3,0,5,8,5};
        int [] end={2,4,6,7,9,9};
        //Sort on ending basis;
        int count=0;
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(0);
        int lastend=end[0];

        for(int i=0;i<end.length;i++){
            if(start[i]>lastend){
                count++;
                ans.add(i);
                lastend=end[i];
            }
        }
        System.out.println(ans);
        System.out.println(count);
    }

}
