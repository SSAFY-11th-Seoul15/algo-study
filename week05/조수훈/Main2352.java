package week05.조수훈;
import java.util.*;
import java.io.*;
public class Main2352 {
    

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n+1];
        int [] dp = new int[n+1];
   
        int result = 1;
   
        for(int i =1;i < n+1 ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int len = 1;
        int idx = 1;
        for(int i =1 ; i< n+1 ;i++){
            if(arr[i] > dp[len]){
                len +=1;
                dp[len] = arr[i];
            }else{
                for(idx = 1; idx<=len; idx++){
                    if(arr[i] <= dp[idx]) break;
                }
                dp[idx] =arr[i];
            }
        }
        
        System.out.println(len);
    

}
