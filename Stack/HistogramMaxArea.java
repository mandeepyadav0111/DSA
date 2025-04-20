import java.util.Stack;

public class HistogramMaxArea {
      public static int largestRectangleArea(int[] heights) {
        int area=0;
        Stack<Integer> st=new Stack<> ();
        int [] leftsmaller=new int[heights.length];
        int [] rightsmaller= new int [heights.length];

       // next smaller right
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                rightsmaller[i]=heights.length;
            }
            else{
                rightsmaller[i]=st.peek();
            }
            st.push(i);
        } 

         // next smaller left
         st=new Stack<>();
         for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                leftsmaller[i]=-1;
            }
            else{
                leftsmaller[i]=st.peek();
            }
            st.push(i);
        }  
        
        for(int i=0;i<heights.length;i++){
            int width=rightsmaller[i]-leftsmaller[i]-1;
            area=Math.max(area,width*heights[i]);
        }
        
        return area;
    }

    public static void main(String[] args) {
        int heights []={2,1,5,6,2,3};
        int result=largestRectangleArea(heights);
        System.out.println(result);

    }
    
}
