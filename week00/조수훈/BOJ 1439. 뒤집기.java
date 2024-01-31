
import java.util.*;
import java.io.*;
public class Main1439 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arr = s.toCharArray();
        if(arr.length == 1){
            System.out.println(0);
            return;
        }
        //1로 맞출때
        int result = 0;
        if(arr[0] == '1'){
            result +=1;
        }
        for(int i = 1; i< arr.length;i++){
            if(arr[i] == '1'){
                if(arr[i-1] == '0'){
                    result +=1;
                }
            }
        }
        //0로 맞출때
        int result2 = 0;
        if(arr[0] == '0'){
            result2 +=1;
        }
        for(int i = 1; i< arr.length;i++){
            if(arr[i] == '0'){
                if(arr[i-1] == '1'){
                    result2 +=1;
                }
             }
            
        }
        System.out.println(Math.min(result,result2));

    }
}
