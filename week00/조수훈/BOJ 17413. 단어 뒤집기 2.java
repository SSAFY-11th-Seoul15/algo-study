
import java.util.*;
import java.io.*;

public class Main17413 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for(char c : s.toCharArray()){
            if(c =='<' ){
                flag = true;
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(c);
            }else if(c == '>'){
                flag=false;
                sb.append(c);
            }else if(c==' '){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(c);
            }else{
                if(flag==true){
                    sb.append(c);
                }
                else{
                    stack.add(c);
                }
            }
              
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        System.out.println(sb);
    }
}







        
    
