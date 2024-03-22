package week06.조수훈;
import java.util.*;
import java.io.*;


public class Main1253 {
    
    static int [] arr;
 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0;i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
       
        }
        Arrays.sort(arr);
        int result = 0;
        for(int i =0 ;i < N; i++){
            int left = 0;
            int right = N-1;
            while(true){
                if(left == i) left++;
                else if(right == i) right--;

                // 결과를 찾을 수 없다.
                if(left >= right) break;
                if(arr[left] + arr[right] > arr[i]) right --;
                else if(arr[left] + arr[right] < arr[i] ) left ++;
                else{      // 좋다!
                    result++;
                    break;
                }


            }

        }
        System.out.println(result);
      
    }
}
