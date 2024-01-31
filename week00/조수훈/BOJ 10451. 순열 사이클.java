import java.util.*;
import java.io.*;
public class Main10451 {

    static int[] parent;
    static int[] arr;

    static public int find_root(int x){
        if(parent[x]!=x){
            parent[x] = find_root(parent[x]);
        }
        return parent[x];
    }
    static public void union(int a, int b){
        a = find_root(a);
        b = find_root(b);
        if(a <= b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    } 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int test_case =0; test_case<T; test_case++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            for(int i = 1; i<N+1; i++){
                parent[i] = i;
            }
            st= new StringTokenizer(br.readLine());
            arr = new int[N+1];
            for(int i =1; i< N+1 ;i++){  
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i =1; i< N+1; i++){
                union(parent[i],arr[i]);
            }
            int result = 0;
            for (int i = 1; i < N + 1; i++) {
                if (parent[i] == i) {
                    result++;
                }
            }
            System.out.println(result);

        }


    }
}
