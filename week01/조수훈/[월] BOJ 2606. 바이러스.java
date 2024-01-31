


// 1. 입력: 컴퓨터의 수    출력: 1번 컴퓨터와 연결된 컴퓨터의 수
// 2. LinkedList를 활용한 DFS  시간복잡도 O(n+e) 
// 3. 그래프를 LinkedList로 구현후, DFS 로 돌며 몇개의 컴퓨터가 연결되어있는지 확인
// 4. LinkedList로 하면 시간이 단축될줄알았으나 줄지않음..? Union-Find 가 훨씬 좋아보임

import java.io.*;
import java.util.*;





public class Main{
	
	static boolean[]visited;
	static int N;
	static int result;
	static LinkedList linkedList;
	public static class Node{
		private int data;
		private Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public static class LinkedList{
		public Node[] nodes;
		public LinkedList(int size) {
			nodes = new Node[size+1];
		}
		public void add(int from, int data) {
			if(nodes[from]==null) {
				nodes[from] = new Node(data);
				return;
			}
			Node temp = nodes[from];
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
		
		
	}
	
	public static void DFS(int start) {
	    visited[start] = true;
	    result += 1;

	    Node temp = linkedList.nodes[start];

	    while (temp != null) {
	        if (!visited[temp.data]) {
	            DFS(temp.data);
	        }
	        temp = temp.next;
	    }
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		linkedList = new LinkedList(N);
		for(int i =0; i< v ;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			linkedList.add(a,b);
			linkedList.add(b,a);
		}
		DFS(1);
		System.out.println(result-1);
	}


}
