package week02.조수훈;

import java.io.*;
import java.util.*;

public class Main11279 {
    
    static class Heap{
        int [] heap;
        int size=0;
        Heap(int n) {
            heap = new int [n+1];
        }

        public void push(int x){
            size +=1;
            heap[size] = x;
            int idx = size;
            while(true){
                if(idx == 1 || heap[idx] >= heap[idx >> 1]){
                    break;
                }
                int tmp = heap[idx >> 1];
                heap[idx>>1] = heap[idx];
                heap[idx] = tmp;
                idx = idx >>1;
            }

        }
        public int pop(){
            int pop = heap[1];
            heap[1] = heap[size];
            size -=1;
            int idx = 1;
            int next;
            while(true){
                next = idx << 1;
                if(next < size && heap[next] > heap[next+1] ){
                    next +=1;
                }
                if( next > size || heap[next] >= heap[idx]){
                    break;
                }
                int tmp = heap[idx];
                heap[idx] = heap[next];
                heap[next] = tmp;
                idx = next;
            }


            return pop;
        }

        public boolean isEmpty(){
            if( size == 0){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);
        for(int i =0;i < N ;i++){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                if(heap.isEmpty()){
                    System.out.println(0);
                }else{

                    System.out.println(-heap.pop());
                }
       
            }else{
                heap.push(-a);
            }
         
        }


    }
}
