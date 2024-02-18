# [금] BOJ 2342. Dance Dance Revolution

1. 문제를 읽고 이해하기
- 입력
    - 지시사항 : 1 ~ 4
    - 0이 나오면 지시사항 종료
- 출력
    - 모든 지시 사항을 만족하는 데 사용되는 최소의 힘

1. 문제의 조건 확인
- 중점을 0, 위를 1, 왼쪽을 2, 아래를 3, 오른쪽을 4
- 0 → 1 ~ 4 : 힘 2
- 같은지역 이동 : 힘 1
- 인접지역 이동 : 힘 3
- 반대지역 이동 : 힘 4

1. 문제를 어떻게 해결할 것인가
- 완탐 : 2(왼쪽|오른쪽)^opSize(100,000) → 불가능
- 그리디 : 현재의 선택이 미래의 선택에 영향을 주므로 불가
- DP 구분 조건 : DP [왼발 위치][오른발 위치][현재까지 index] 3가지가 같으면 동일
- DP[left][right][index] = x 의미
    
    왼발, 오른발, 인덱스에 대해 x 는 그 때까지의 최소 힘
    

1. 문제 풀이 흐름

```java
if (모든 지시사항을 했나?) return 0; // 더 진행할 지시가 없으니 힘 0 리턴
dp[left][right][index] = Min(dfs(왼발에서이동한위치,right,index+1)+왼발이동힘,
 dfs(left,오른발에서이동한위치,index+1)+오른발이동힘)
```

1. 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> ops;
	static int opSize;
	static int[][][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int op;
		ops = new ArrayList<>();
		while (true) {
			op = Integer.parseInt(st.nextToken());
			//1~4 => 0~3
			if (op != 0) ops.add(op - 1);
			else break;
		}
		opSize = ops.size();
		// 그리디 가능한가? => 불가능 : 현재 선택이 미래의 선택에 영향을 준다.
		// 완탐 가능한가? => 불가능 : 2(왼쪽|오른쪽)^opSize(100,000)
		// DP 가능한가? => 모든 문제는 dp로 가능. 조건을 생각하자.
		//왼발 오른발 현재 인덱스 같다면?
		visited = new int[5][5][opSize];
		System.out.println(backTrack(4, 4, 0));
	}
	
	static int backTrack(int left, int right, int opIndex) {
		if (opIndex == opSize) {
			//더 고를게 없다.
			return 0;
		}
		if (visited[left][right][opIndex] != 0)
			return visited[left][right][opIndex];
		int leftpower = power(left, ops.get(opIndex));
		int rightpower = power(right, ops.get(opIndex));
		return visited[left][right][opIndex] = 
				Math.min(backTrack(ops.get(opIndex), right, opIndex + 1) + leftpower, backTrack(left, ops.get(opIndex), opIndex + 1) + rightpower);
	}
	
	static int power (int foot, int op) {
		if (foot == op) return 1;
		else if (foot == 4) return 2;
		else if ((foot + 2) % 4 == op) return 4;
		else return 3;
	}
}
```