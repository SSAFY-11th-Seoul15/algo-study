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
        int [] dp2 = new int[n+1];
        int result = 0;
   
        for(int i =1;i < n+1 ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            dp2[i] = 1;
        }
        
        // 증가하는 부분 수열
        for(int i = 2 ; i< n+1; i++){
            for(int j = 1; j< i; j++){
                if( arr[i] > arr[j] ){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    result = Math.max(dp[i],result);
                }
            } 
        }
  

        // // 감소하는 부분 수열
        // for(int i = 2 ; i< n+1; i++){
        //     for(int j = 1; j< i; j++){
        //         if( arr[i] < arr[j]){
        //             dp2[i] = Math.max(dp2[j]+1, dp2[i]);
        //             result = Math.max(dp2[i],result);
        //         }
        //     } 
        // }
      
        System.out.println(result);
    }

}
