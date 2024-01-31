import java.util.*;
import java.io.*;
public class Main2295 {

    static long[] arr;
    static boolean[] visited;
    static List<Long> results = new ArrayList<>();
    public static void combination(int start, int r, long sum){
            if(r==3){
                results.add(sum);
                return;
            }
            for(int i= 0; i< arr.length; i++){
                    combination(i+1, r+1, sum+arr[i]);
            }
        }
    

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new long[N];
        visited = new boolean[N];
        for(int i =0; i< N ;i++){
            st=new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }
        combination(0, 0, 0);
        Arrays.sort(arr);
        for(int i =arr.length-1; i>-1; i--){
            if(results.contains(arr[i])){
                System.out.println(arr[i]);
                return;
            }
        }


    }
}
