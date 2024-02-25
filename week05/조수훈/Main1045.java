package week05.조수훈;

import java.util.*;
import java.io.*;
public class Main1045 {
    

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        public Edge(int from , int to){
            this.from = from;
            this.to = to;
        }
        @Override
        public int compareTo(Edge o) {
            if(this.from < o.from  && this.to < o.from){
                return -1;
            }
            return 0;
        }
        @Override
        public String toString() {
            return "Edge [from=" + from + ", to=" + to + "]";
        }
    
        
    }

    static int [] parent;
    static int [] count;

    private static int find(int x ){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    private static void union(int a, int b){
        int t1 = find(a);
        int t2 = find(b);
        if(t1 == t2) {
            return;
        }
        if(t1 < t2){
            parent[t2] =t1;
        }
        else{
            parent[t1] =t2;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        parent = new int[N];
        count = new int[N];
        for(int i =0;i < N; i++){
            parent[i] = i;
        }
        int M = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        for(int i =0;i < N ;i++){
            String[] t = br.readLine().split("");
            for(int j =0;j< t.length; j++){
                if(t[j].equals("Y")){
                    edges.add(new Edge(i,j));
                }
            }
        }
        Collections.sort(edges);
        System.out.println(edges.toString());
        for(Edge e : edges){
            int from = e.from;
            int to = e.to;

            if(find(from)!=find(to)){
                union(from, to);
                count[from ] +=1;
                count[to] +=1;
            }


        }

        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(count));


    }
}
