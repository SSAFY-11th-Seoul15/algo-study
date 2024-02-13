package week03.조수훈;
import java.util.*;
import java.io.*;
public class Main15644 {
    static int N;
    static int M;
    static String [][] graph;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static boolean [][][][][]visited ;


    public static void go(int x1, int y1, int x2, int y2, int d){
        String k = graph[x1][y1];
        String k2 = graph[x2][y2];
        int px1 = x1;
        int py1 = y1;
        int px2 = x2;
        int py2 = y2;
        
        while(true){
            int nx1 = x1+dx[d];
            int ny1 = y1+dy[d];
            if( nx1 >= N || nx1 <0 || ny1>= M || ny1 < 0){
                break;
            } 
            if( graph[nx1][ny1].equals("#") ||graph[nx1][ny1].equals("R")||graph[nx1][ny1].equals("B")){
                break;
            }
            if(graph[nx1][ny1].equals("O")){
                break;
            }
            x1 = nx1;
            y1 = ny1;
        }
        graph[x1][y1] = k;
        while(true){
            int nx2 = x2+dx[d];
            int ny2 = y2+dy[d];
            if( nx2 >= N || nx2 <0 || ny2>= M || ny2 < 0){
                break;
            } 
            if( graph[nx2][ny2].equals("#") ||graph[nx2][ny2].equals("O")||graph[nx2][ny2].equals("R")||graph[nx2][ny2].equals("B")){
                break;
            }
            x2 = nx2;
            y2 = ny2;
        }
        graph[x2][y2] = k2;
        graph[px1][py1] = ".";
        while(true){
            int nx1 = x1+dx[d];
            int ny1 = y1+dy[d];
            if( nx1 >= N || nx1 <0 || ny1>= N || ny1 < 0){
                break;
            } 
            if( graph[nx1][ny1].equals("#") ||graph[nx1][ny1].equals("O")||graph[nx1][ny1].equals("R")||graph[nx1][ny1].equals("B")){
                break;
            }
            x1 = nx1;
            y1 = ny1;
        }
        graph[x1][y1] = k;
        while(true){
            int nx2 = x2+dx[d];
            int ny2 = y2+dy[d];
            if( nx2 >= N || nx2 <0 || ny2>= M || ny2 < 0){
                break;
            } 
            if( graph[nx2][ny2].equals("#") ||graph[nx2][ny2].equals("O")||graph[nx2][ny2].equals("R")||graph[nx2][ny2].equals("B")){
                break;
            }
            x2 = nx2;
            y2 = ny2;
        }
        graph[x2][y2] = k2;
        graph[px2][py2] = ".";

        
    }


    public static int recursive(int x1 , int y1 , int x2 ,int y2 , int cnt){

    
        if( cnt == 10){
            return -1 ;
        }

        for(int d =0;d < 4; d++){
            if(visited[x1][y1][x2][y2][d]==false){
                visited[x1][y1][x2][y2][d] = true;
                go(x1,y1,x2,y2 ,d);
                boolean flag = false;
                for(int i =0;i < N ;i++){
                    for(int j =0; j< M ;j++){
                        if(graph[i][j].equals("R")){
                            x1 = i;
                            y1 = j;
                            flag =true;
                        }
                        else if(graph[i][j].equals("B")){
                            x2 = i;
                            y2 = j;
                            
                        }
                    }
                }
                if(flag == true){
            
                    cnt = recursive(x1, y1, x2, y2, cnt+1);
                }
            }
        }


        return cnt;


    }
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[N][M];
        visited = new boolean[N][M][N][M][4];
        int x1=0,x2=0,y1=0,y2 = 0;
        for(int i =0;i < N ;i++){
            String[] t = br.readLine().split("");
            for(int j =0; j< M ;j++){
                graph[i][j] = t[j];
                if(graph[i][j].equals("R")){
                    x1 =i;
                    y1=j;
                }
                else if(graph[i][j].equals("B")){
                    x2 = i;
                    y2 = j;
                }
            }
        }
        System.out.println(recursive(x1,y1,x2,y2,0));
        System.out.println(Arrays.deepToString(graph));


    }
}
