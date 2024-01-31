import java.util.*;
import java.io.*;
public class Main7795 {
    
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:/codingtest/CodingTest/JavaCodingTest/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int test_case=0 ; test_case<T; test_case++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int [] arr1 = new int[a];
            st = new StringTokenizer(br.readLine());
            for(int i =0; i< a ;i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            int[] arr2 = new int[b];
            st = new StringTokenizer(br.readLine());
            for(int i =0; i< b ;i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr2);
            int result = 0;
            for(int i =0; i< a; i++){
                int start =0;
                int end = arr2.length-1;
                while(start<=end){
                    int mid = (start+end)/2;
                    if(arr1[i] <= arr2[mid]){
                        end = mid -1;
                    }
                    else{
                        start = mid + 1 ;
                    }
                  
                }
                result += start;
          

        }
        System.out.println(result);
    
        }
    }
}

