import java.util.*;
import java.io.*;
public class Main1449 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for(int i =0 ; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }  
        Arrays.sort(arr);
        int start = arr[0];
        int result = 1;
        for(int i=0; i< arr.length;i++){
            if( start + (L-1) < arr[i]){
                result +=1;
                start = arr[i];
            }
        }


        System.out.println(result);
    }
}
