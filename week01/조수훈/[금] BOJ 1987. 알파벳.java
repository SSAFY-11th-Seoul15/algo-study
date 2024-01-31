// 달이 차오른다 처럼 비트마스킹으로 풀이 가능할듯함


// 이 풀이는 시간초과 Stack 을 HashSet 으로 바꾸면 해결가능
// 그 이유는 Stack - LinkedList 로 이루어져있음, 하지만 마지막 요소를 제거하려면
// 처음 부터 끝까지 타고 내려가야함
import java.util.*;
import java.io.*;
public class Main1987 {
    
    static int R;
    static int C;
    static boolean [][] visited;
    static String[][] graph;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static Stack<String> alph = new Stack<>();
    static List<Integer> results = new ArrayList<>();

    public static void DFS(int x, int y, int d){
        boolean flag = true;
        // 종료 조건 ( 인접한 그래프에 갈수있는곳이 없을떄)
        for(int i =0; i< 4 ;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= R || nx < 0 || ny >=C || ny <0){
                continue;
            }
            if(visited[nx][ny] ==true){
                continue;
            }
            if(!alph.contains(graph[nx][ny])){
                flag = false;
            }
        }
        if(flag == true){
            results.add(d);
            System.out.println(x+" " + y+" "+ d);
            return;
        }


        for(int i =0; i< 4 ;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= R || nx < 0 || ny >=C || ny <0){
                continue;
            }
            if(visited[nx][ny] == false && !alph.contains(graph[nx][ny])){
                visited[nx][ny] = true;
                alph.add(graph[nx][ny]);
                DFS(nx,ny,d+1);
                visited[nx][ny] = false;
                alph.pop();
            }

        }
        
   
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new String[R][C];
        visited = new boolean[R][C];
        for(int i =0; i< R ;i++){
            String [] t =br.readLine().split("");
            for(int j =0; j< C  ;j++){
                graph[i][j] = t[j];
            }
        }
        
        visited[0][0] = true;
        alph.add(graph[0][0]);
        DFS(0,0,1);
        System.out.println(Collections.max(results));
    }




}