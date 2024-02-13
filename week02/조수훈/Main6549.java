package week02.조수훈;


import java.util.*;
import java.io.*;



public class Main6549 {

    static int N;
    static int [] arr;
    static int [] segtree;

    private static int getMax(int i, int j){
        // i와 j 사이중에 가장 작은 높이 찾아서 mid로 설정
        int midIdx = i + N;
        int left = i  + N ;
        int right = j  + N ;
        
        while(left<=right){
            if(left%2==1){
                if(arr[segtree[midIdx]] > arr[segtree[left]]) {
                    midIdx = left;
                }
                left+=1;
            }
            if(right%2==0){
                if(arr[segtree[midIdx]] >arr[segtree[right]]) {
                    midIdx = right;
                }
                right-=1;
            }
            left/=2;
            right/=2;
        }
        int width = arr[segtree[midIdx]] * (i-j+1);

        int tmp = 0;
        //mid 를 기준으로 분할정복
        if( i < segtree[midIdx]){
            tmp = getMax(i,segtree[midIdx]-1);
            width = Math.max(width, tmp);
        }
        if( segtree[midIdx] < j){
            tmp =getMax(segtree[midIdx]+1,j);
            width = Math.max(width, tmp);
        }

        return width;
    }

    public static void main(String[] args) throws Exception{
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i =0; i< N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
      
        // segtree 만들기
        segtree = new int[2*N];
        for(int i =0;i< N; i++){
            segtree[i+N] = i;
        }
        for(int i=N-1;i>0;i--){
            if(arr[segtree[i*2]] > arr[segtree[i*2+1]]){
                segtree[i] = segtree[i*2+1];
            }else{
                segtree[i] = segtree[i*2];
            }
        }
        System.out.println(Arrays.toString(segtree));

        System.out.println(getMax(0,N-1));
        

    }
}
