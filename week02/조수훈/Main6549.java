package week02.조수훈;


import java.util.*;
import java.io.*;



public class Main6549 {


 

  


    public static void main(String[] args) throws Exception{
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [] arr = new int[N+2];
        for(int i =1; i< N+1 ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int result = 0;
       
        for(int i =0 ; i < N+2 ; i++){
            while(!stack.isEmpty()){
                int left = stack.peek();
                if(arr[left] <= arr[i] ) break;
                stack.pop();
                result = Math.max(result, arr[left]* (i-stack.peek()-1) );
            }
            stack.push(i);
        }
        System.out.println(result);

        

    }
}
