package week06.조수훈;
import java.util.*;
import java.io.*;
public class Main3273 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        String [] t = br.readLine().split(" ");
        for(int i =0 ;i< n ;i++){
            arr[i] = Integer.parseInt(t[i]);
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        while(true){

            if(arr[start] + arr[end]> x){
                end-=1;
            }
            else{
                
            }

        }


        
    }
}
