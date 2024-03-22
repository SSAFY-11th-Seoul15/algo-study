package week06.조수훈;
import java.util.*;
import java.io.*;
public class Main4485 {
    static int N;
    static int [][] graph;
    static boolean[][] visited;
    static int [] dx ={0,1,0,-1};
    static int [] dy ={1,0,-1,0};
    static int [][] dp;
  
    static class Point implements Comparable<Point>{

        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
    
            return graph[this.x][this.y] - graph[o.x][o.y];
        }
        
    }

    public static void BFS(int x, int y){

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(x,y));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            int tx = p.x;
            int ty = p.y;
        
            for(int i =0 ;i< 4; i++){
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(nx >= N || nx <0 || ny >= N || ny <0){
                    continue;
                }
                if(visited[nx][ny] == true){
                    continue;
                }
                if(graph[nx][ny] + dp[tx][ty] < dp[nx][ny]){
                    dp[nx][ny] = graph[nx][ny] +dp[tx][ty] ;
                    queue.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            
            }
        }


    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time =0;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }
            graph = new int[N][N];
            visited = new boolean[N][N];
            dp = new int[N][N];
            for(int i=0;i<N;i++){
                Arrays.fill(dp[i],Integer.MAX_VALUE);
            }
            StringTokenizer st;
            for(int i = 0;i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0 ;j<N; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited[0][0] = true;
            dp[0][0] = graph[0][0];
            BFS(0,0);
            
            time +=1;
            System.out.println(Arrays.deepToString(dp));
        }
        


    }
}