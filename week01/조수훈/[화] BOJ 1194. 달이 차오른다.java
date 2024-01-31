
/*
 * 입력: N, M , 미로의 모양  출력: 미로 탈출하는데 드는 이동횟수의 최솟값

BFS 를 통해서 최단 거리를 구함

일반적인 BFS 방법으로 visited를 만들고 돌면 , key 를 들고 방문했던 곳으로 다시 돌아갈수없음

따라서 해당 key 를 가지고 방문했는지를 판단하여야 함으로 visited를 3차원으로 만듬

큐에도 가지고 있는 key 들을 넣어줘야함

key 들을 어떻게 한번에 큐에 넣어줄수있을까  → 비트마스킹 활용
 */



 // 첫 번째 풀이 ( 코드 더 깔끔히 짜야함 )
import java.util.*;
import java.io.*;


public class Main {
	static int N;
	static int M;
	static int startX;
	static int startY;
	static String[][] graph;
	static int[][][] visited;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};

	public static void BFS(int x,int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y,0b000000});
		visited[x][y][0b000000] = 0;
		while(queue.size()!=0) {
			int[] v =queue.poll();
			if(graph[v[0]][v[1]].equals("1")) {
				System.out.println(visited[v[0]][v[1]][v[2]]);
				return;
				
			}
			for(int i =0; i< 4;i++) {
				int nx = dx[i] + v[0];
				int ny = dy[i] + v[1];
				if(nx >= N || nx <0 || ny >= M || ny<0 || graph[nx][ny].equals("#")) {
					continue;
				}
				if(graph[nx][ny].equals("A") && ((v[2] & 0b000001) != 0b000001 )) {
					continue;
				}
				if(graph[nx][ny].equals("B") && ((v[2] & 0b000010) != 0b000010 )) {
					continue;
				}
				if(graph[nx][ny].equals("C") && ((v[2] & 0b000100) != 0b000100 )) {
					continue;
				}
				if(graph[nx][ny].equals("D") && ((v[2] & 0b001000) != 0b001000 )) {
					continue;
				}
				if(graph[nx][ny].equals("E") && ((v[2] & 0b010000) != 0b010000 )) {
					continue;
				}
				if(graph[nx][ny].equals("F") && ((v[2] & 0b100000) != 0b100000 )) {
					continue;
				}
				
			
				if(graph[nx][ny].equals("a") && visited[nx][ny][v[2]|0b000001]==0) {
					visited[nx][ny][v[2]|0b000001] = visited[v[0]][v[1]][v[2]] + 1;
					queue.add(new int[] {nx,ny,v[2]|0b000001});
					continue;
				}
				if(graph[nx][ny].equals("b") && visited[nx][ny][v[2]|0b000010]==0) {
					visited[nx][ny][v[2]|0b000010] = visited[v[0]][v[1]][v[2]] + 1;
					queue.add(new int[] {nx,ny,v[2]|0b000010});
					continue;
				}
				if(graph[nx][ny].equals("c") && visited[nx][ny][v[2]|0b000100]==0) {
					visited[nx][ny][v[2]|0b000100] = visited[v[0]][v[1]][v[2]] + 1;
					queue.add(new int[] {nx,ny,v[2]|0b000100});
					continue;
				}
				if(graph[nx][ny].equals("d") && visited[nx][ny][v[2]|0b001000]==0) {
					visited[nx][ny][v[2]|0b001000] = visited[v[0]][v[1]][v[2]] + 1;
					queue.add(new int[] {nx,ny,v[2]|0b001000});
					continue;
				}
				if(graph[nx][ny].equals("e") && visited[nx][ny][v[2]|0b010000]==0) {
					visited[nx][ny][v[2]|0b010000] = visited[v[0]][v[1]][v[2]] + 1;
					queue.add(new int[] {nx,ny,v[2]|0b010000});
					continue;
				}
				if(graph[nx][ny].equals("f") && visited[nx][ny][v[2]|0b100000]==0) {
					visited[nx][ny][v[2]|0b100000] = visited[v[0]][v[1]][v[2]] + 1;
					queue.add(new int[] {nx,ny,v[2]|0b100000});
					continue;
				}
				
				if(visited[nx][ny][v[2]]==0) {
					visited[nx][ny][v[2]] = visited[v[0]][v[1]][v[2]]+1;
					queue.add(new int[] {nx,ny,v[2]});
				}
				
			
			}
			
		}
		System.out.println(-1);
		return;
		
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new String[N][M];
		visited = new int[N][M][0b111111+1];
		for(int i =0; i< N ;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j< M; j++) {
				graph[i][j] = temp[j];
				if(graph[i][j].equals("0")) {
					startX = i;
					startY = j;
				}
			}
		}
		BFS(startX, startY);

		
		
	}
}
