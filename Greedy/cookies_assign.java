public class cookies_assign {
    public static void main(String[] args) {
        int[] greed={1,2,3,2,1,2,1,1};
      int[] cookies={1,2,2,3,1,2,2,1};
        int i=0;
        int j=0;
        while(i<greed.length && j<cookies.length){
            if(greed[i]<=cookies[j]){
                i++;
            }
            j++;
        }

        System.out.println("children whose hunger can be fulfiled with greedy:" + (i+1));
    }
    
}
