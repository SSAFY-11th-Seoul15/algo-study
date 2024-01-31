// 백트래킹 활용하여 궁수 3명 선택 MC3

// 3명이 BFS를 돌며 적을 죽임 NXM

// 최대 몇개의 턴 N

// O(MC3) * ( N*M) * N 이므로 가능

// 적들이 내려오는 상황과, 궁수가 올라가는 상황이 동일함으로 궁수가 올라가는 것을 선택

// 어려웠던 점은 같은 턴에서 적을 겹치게 죽일수있다는 점이다.

// 해결방법은

// dead라는 배열을 만들어서 죽은적은 false처리를 하였고, 그래프에서 -1로 변경하였다.


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

