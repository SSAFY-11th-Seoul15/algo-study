package week05.조수훈;
import java.io.*;
import java.util.*;
public class Main2293 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] coins = new int[n];
        int [] dp = new int[k+1];
        for(int i =0;i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
            dp[0]=1;
        }

        for(int j = 0 ;j< n; j++){
            for(int i =1; i< k+1; i++){
                if( i - coins[j] >=0){
                    dp[i] +=dp[i-coins[j]];
                }
            }
        }
        System.out.println(dp[k]);



    }
}
