package week02.조수훈;

import java.io.*;
import java.util.*;
public class Main10845 {
    
    static StringBuilder sb = new StringBuilder();
    static class Queue{

        static int [] arr = new int[10001];
        static int begin = 0;
        static int end = 0;
      
        void push(int x){
            arr[end] = x;
            end +=1;
        }
        void pop(){
            if(end == begin){
               sb.append(-1+"\n");
            }
            else{
                sb.append(arr[begin]+"\n");
                begin +=1;
            }
        }
        void size(){
            sb.append((end - begin)+"\n");
        }
        void empty(){
            sb.append(((begin == end)?1:0)+"\n");
        }
        void front(){
            sb.append(((begin==end)?-1:arr[begin])+"\n");
        }
        void back(){
            sb.append(((begin == end )? -1: arr[end-1])+"\n");
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int last = 0;
        Queue queue = new Queue();
        
        for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			
			switch(S) {
			case "push" :
				last = Integer.parseInt(st.nextToken());
				queue.push(last);
				break;
			case "pop" :
				queue.pop();
                break;
			case "size" :
				queue.size();
				break;
			case "empty" :
				queue.empty();
				break;
			case "front" :
				queue.front();
				break;
			case "back" :
				queue.back();
				break;
			}
		}
		System.out.println(sb.toString());
	}



}
