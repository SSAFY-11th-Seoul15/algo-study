package week05.조수훈;
import java.util.*;
import java.io.*;
public class Main2352 {
    

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        
        for(int i=1;i < n+1; i++){
            int t = Integer.parseInt(st.nextToken());
            if(!stack.isEmpty()){
                if(stack.peek() > t){
                    result = Math.max(result,stack.size());
                    while(!stack.isEmpty()){
                        int v = stack.pop();
                        if( stack.isEmpty() ||stack.peek() < t){
                            stack.add(t);
                            System.out.println(stack.toString());
                            break;
                        }
                    }
                }else{
                    stack.add(t);
                    System.out.println(stack.toString());
                }
            }else{
                stack.add(t);
                System.out.println(stack.toString());
            }

        }
        result = Math.max(result,stack.size());

        System.out.println(result);
    }

}
