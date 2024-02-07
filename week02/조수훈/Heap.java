package week02.조수훈;
import java.util.*;
import java.io.*;

public class Heap {

    static int N =10;
    static int [] arr = {0,1,4,3,4,8,6,4,1,2};

    public static class minHeap{
        int [] heap  = new int[N+1];
        int size = 0;


        public minHeap(){
        }
        public void push(int x){
            size +=1;
            heap[size] =x;
            int idx = size;
            while(true){
                if(idx == 1 || heap[idx >> 1] <= heap[idx]){
                    break;
                }
                int tmp = heap[idx>>1];
                heap[idx>>1] = heap[idx];
                heap[idx] = tmp;
                idx = idx >>1;
            }

        }
        public int pop(){
            int pop = heap[1];
            heap[1] = heap[size];
            size -=1;
            int idx =1;
            int next;
            while(true){
                next = idx <<1;
                if(next < size && heap[next] > heap[next+1]){
                    next +=1;
                }
                if(next > size || heap[next] >= heap[idx]){
                    break;
                }
                int tmp = heap[idx];
                heap[idx] = heap[next];
                heap[next] = tmp;
                idx = next;
            }
            return pop;

        }

    }
    public static void main(String[] args) {
        
        minHeap heap = new minHeap();
        for(int i =0;i < 10; i++){
            heap.push(arr[i]);
        }
        for(int i =0;i < 10; i++){
            System.out.println(heap.pop()+" ");
        }

    }    

}
