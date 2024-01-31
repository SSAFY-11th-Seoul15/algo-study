import java.util.*;
import java.io.*;
public class Main15686 {

    static class Point{
        public int x;
        public int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int [][] graph;
    static List<Point> chicken = new ArrayList<>();
    static List<Point> house ;
    static boolean [][]visited;
    static List<Point> t = new ArrayList<>();
    static List<Integer> result= new ArrayList<>();
    public static void combination(int r , int start){
        if(r == M){
            int sum = 0;
            //2N
            for(Point k : house){
                //M
                int temp = Integer.MAX_VALUE;
                for(Point p : t){
                    int d = Math.abs(k.x-p.x) + Math.abs(k.y-p.y);
                    temp = Math.min(d, temp);
                }
                sum += temp;
            }
            result.add(sum);
            return;
        }
        for(int i =start; i< chicken.size(); i++){
            int tx =chicken.get(i).x;
            int ty =chicken.get(i).y;
            if(visited[tx][ty]==false){
                visited[tx][ty] = true;
                Point p =new Point(tx,ty);
                t.add(p);
                combination(r+1, i);
                visited[tx][ty] = false;
                t.remove(t.size()-1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        visited = new boolean[N][N];
        house = new ArrayList<>();
        for(int i =0 ; i< N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< N ; j++){
               graph[i][j] = Integer.parseInt(st.nextToken());
               if(graph[i][j] == 2){
                chicken.add(new Point(i,j));
               }
               if(graph[i][j] == 1){
                house.add(new Point(i,j));
               }
            }
        }
        combination(0, 0);
        System.out.println(Collections.min(result));
    }

}