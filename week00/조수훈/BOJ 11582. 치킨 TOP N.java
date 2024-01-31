import java.util.*;
import java.io.*;
public class Main11582 {
    static int[] arr;
    public static void rescursive(int N , int k){

        if(N == k){
            return;
        }else{
            int people = N / 2;
            int size = arr.length / people;
            int index = 0;
            for(int i =0; i< people; i++){
                int[] temp = new int[size];
                for(int p = 0; p< size; p++){
                    temp[p] = arr[p+index];
                }
                Arrays.sort(temp);
                for(int p = 0; p< size; p++){
                    arr[p+index] = temp[p];
                }
                index +=size;
            }
            rescursive(N/2, k);
        }

        return;
    }
    public static void main(String[] args) throws Exception{
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i =0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        rescursive(N, k);
        for(int a : arr){
            System.out.print(a+" ");
        }
    }
}
