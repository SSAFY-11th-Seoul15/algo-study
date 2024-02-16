



```java
package ps2;
import java.util.*;
import java.io.*;
public class undukgil {
	static int TC;
	static int N;
	static int [] arr;
	static int [] dp;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for(int test_case = 0 ; test_case < TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());	
			for(int i =1;i< N+1 ;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int[N+1];
			dp[1] = 1;
			int r = 1;
			//최대 증가하는 부분 수열의 길이 구하기
			for(int i =2 ;i< N+1;i++) {
				dp[i] = 1;
				for(int j =1 ; j< i ;j++) {
					if(arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
						
					}
				}	
				r = Math.max(r, dp[i]);
			}

			System.out.println("#"+(test_case+1)+" "+(arr.length-r-1));

		}
		
	}
	
	
}





```
