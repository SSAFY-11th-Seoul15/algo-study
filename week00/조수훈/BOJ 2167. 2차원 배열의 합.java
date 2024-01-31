import java.util.*;
import java.io.*;

public class Main2167 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] graph = new int[N+1][M+1];
        for(int i =1; i< N+1 ;i++){
            st =new StringTokenizer(br.readLine());
            for(int j = 1; j< M+1; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N+1][M+1];
        for(int i=1; i< N+1; i++){
            for(int j =1; j< M +1; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + graph[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for(int i =0; i< K ;i++){
            st =new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = 0;
            result = dp[x2][y2] - dp[x1-1][y2] - dp[x2][ y1-1] + dp[x1-1][y1-1];
            System.out.println(result);

        }
        






    }
}
