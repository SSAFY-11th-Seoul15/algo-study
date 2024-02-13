package week03.조수훈;
import java.util.*;
import java.io.*;
public class Main17143 {
	static int R;
	static int C;
	static int M;
	static int [][][] graph;
	static int [][][] moved_graph;
	static int [] dx = {0,-1,1,0,0};
	static int [] dy = {0,0,0,1,-1};

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[R+1][C+1][3];
		for(int i= 0;i < M ;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			graph[r][c][0] = s;
			graph[r][c][1] = d;
			graph[r][c][2] = z;
		}
		int result = 0;
		//사람 이동
		for(int people = 1; people < C+1; people++) {
			result = chatch(result, people);
			List<int[]> sharks = wantToMove();
			moved_graph = new int[R+1][C+1][3];
			for(int[] t : sharks) {
				// 넘어가면 방향이 바뀜
				int r = t[0];
				int c = t[1];
				int s = t[2];
				int d = t[3];
				int z = t[4];
                // 0 1 2 3 4 5
                //     ->
                if(d==1 || d==2){
                    if(C-1 != 0) s = s%(2*(R-1));
                }else{
                    if(R-1 != 0) s = s%(2*(C-1));
                }
                
				for(int i=0; i< s; i++) {
					int nx = r + dx[d];
				    int ny = c + dy[d];
          
				    if (nx <= 0 || nx > R || ny <= 0 || ny > C) {
                        r = r - dx[d];
                        c = c - dy[d];
				        if(d==1) {
				        	d = 2;
				        }
				        else if(d==2) {
				        	d = 1;
				        }
				        else if(d==3) {
				        	d = 4;
				        }
				        else if(d==4) {
				        	d = 3;
				        }
				        continue;
				    }else{
                        r = nx;
                        c = ny;
                    }
				
				}
                if(moved_graph[r][c][2] < z) {
                    moved_graph[r][c][0] = s;
                    moved_graph[r][c][1] = d;
                    moved_graph[r][c][2] = z;
                }
			}
			copy();
		}
		System.out.println(result);
	}

	private static List<int[]> wantToMove() {
		// 상어 이동
		List<int[]> sharks = new ArrayList<>();
		for(int i =1;i < R+1 ;i++) {
			for(int j =1;j<C+1; j++) {
				if(graph[i][j][2]!=0) {
					sharks.add(new int[] {i,j, graph[i][j][0], graph[i][j][1], graph[i][j][2]});
				}
			}
		}
		return sharks;
	}

	private static void copy() {
		for (int i = 0; i < R+1; i++) {
		    for (int j = 0; j < C+1; j++) {
		    	for(int k =0;k<3; k++) {
		    		graph[i][j][k] =moved_graph[i][j][k];
		    	}
		    }
		}
		
	}

	private static int chatch(int result, int people) {
		//상어 먹힘
		for(int i =1;i < R+1; i++) {
			if(graph[i][people][2]!=0) {
				result += graph[i][people][2];
				graph[i][people][0] = 0;
				graph[i][people][1] = 0;
				graph[i][people][2] = 0;
				break;
			}
		}
		return result;
	}
}
