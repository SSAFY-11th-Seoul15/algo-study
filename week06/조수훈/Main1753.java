package week06.조수훈;
import java.io.*;
import java.util.*;

public class Main1753 {
    
    static int V;
    static int E;
    static int K;
    static Edge[] edges;
    static class Edge{
        int from;
        int to;
        public Edge(int from , int to){
            this.from = from;
            this.to = to;
        }
        
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        edges = new Edge[E];
        for(int i =0 ;i< E;i++){
            


        }




    }

}
