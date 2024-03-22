package week06.조수훈;

import java.util.*;
import java.io.*;
public class Main1504 {
    

    static int N;
    static int E;
    static List<Edge> [] edges;
    static int[] dist;
    private static int INF = 200000000; //200,000 * 1,000
    static class Edge implements Comparable<Edge>{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.weight - o.weight;
        }
    }


    static void BFS(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
      
        dist[start] = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            for(int i =0 ;i < edges[e.to].size();i++){
                Edge ne = edges[e.to].get(i);
                if(dist[ne.to] > e.weight + ne.weight){
                    dist[ne.to] = e.weight + ne.weight;
                    pq.add(new Edge(ne.to, e.weight+ne.weight));
                }
            }
        }


    }




    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i =0 ;i<N+1; i++){
            edges[i] = new ArrayList<Edge>();
        }
        for(int i=0 ;i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b,c));
            edges[b].add(new Edge(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        long result = Long.MAX_VALUE;
        BFS(1);
        int d1 = dist[v1];
        int d2 = dist[v2];
 
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        BFS(v1);
        int v1tov2 = dist[v2];
        int v1toN = dist[N];
      

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        BFS(v2);
        int v2tov1 = dist[v1];
        int v2toN = dist[N];


        int ans1 =d1+v1tov2+v2toN;
        int ans2 = d2 +v2tov1+v1toN;
        result = Math.min(ans1, ans2);



        if((ans1 >= INF || ans1 <0 )&& (ans2>= INF||ans2<0)){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
        
  



        
    }
}
