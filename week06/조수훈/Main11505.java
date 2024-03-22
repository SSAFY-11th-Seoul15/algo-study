package week06.조수훈;
import java.util.*;
import java.io.*;
public class Main11505 {
    
    static long [] segtree;
    static int M;
    static int K;
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        segtree = new long[2 * N];
        for(int i = 0 ;i < N;i++){
            segtree[i+N] = Long.parseLong(br.readLine());
        }
        for(int i = N-1; i> 0 ;i--){
            segtree[i] = (segtree[i*2]% 1000000007) * (segtree[i*2+1]% 1000000007);
        }


        for(int i =0 ;i< M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
      
            if(a == 1){
                // update
                int idx = b+N-1;
                segtree[idx] = c;
                while(idx > 1 ){
                    idx = idx >> 1;
                    segtree[idx] = (segtree[idx*2] % 1000000007) * (segtree[idx*2+1] % 1000000007);
                    segtree[idx] = segtree[idx] % 1000000007;
                }

            }else{
                // 구간 곱
                int left = b+N-1;
                int right = c+N-1;
                long result = 1;
                while(left <= right){
                    if(left%2 ==1){
                        result *=segtree[left]%1000000007;
                        result = result%1000000007;
                        left +=1;
                    }
                    if(right%2==0){
                        result *=segtree[right]%1000000007;
                        result = result%1000000007;
                        right -=1;
                    }
                    left/=2;
                    right/=2;

                }
                System.out.println(result%1000000007);


            }




        }


    }
}
