# [금] BOJ 1013. Contact

1. 문제를 읽고 이해하기
- 입력
    - T : 테스트 케이스
    - 수신 전파 ( 1 ≤ 전파길이 ≤ 200 )
- 출력
    - 수신 전파가 제시된 패턴이면 YES
    - 아니면 NO

1. 문제의 조건 확인
- (100+1+ | 01)+
- + : 반복
- | : or

1. 문제를 어떻게 해결할 것인가
- 100….1….. or 01의 반복임.
- 10011001 의 경우 그리디로 해결되지 않음
    - 10011삭제하면 안되지만 1001 삭제하면 됨
- 확실히 안되는 경우
    - 맨 뒤가 0
    - 11로 시작
- 100…1…이 확실한 경우
    - 100으로 시작
- 01이 확실한 경우
    - 01로 시작
- 위의 경우에 맞춰 작성하면 됨.
- 순서대로 확인하므로 시간복잡도는 전파의 길이(N)

1. 문제 풀이 흐름

```java
위에서 판단한 것을 그대로 옮기므로 생략
```

1. 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String input;
		//수신 전파
		//(100+1+ | 01)+
		// 100+1+ 또는 01 있으면 지우기
		int idx;
		boolean flag;
		for (int tc = 1; tc <= T; tc++) {
			input = br.readLine();
			//10000000...111..... -> 제거가능
			//1로시작? 왼쪽꺼
			//0으로시작? 오른쪽꺼
			//안됨
			/*
			 	100001100111
				100001
				100111	
			 */
			flag = false;
			while (input.length() > 0) {
				if (input.startsWith("100")) {
					idx = 2;
					while (idx < input.length() && input.charAt(idx) == '0')
						idx++;
					//모든 0을 지났다.
					if (idx == input.length()) {
						//0으로 끈나버림?
						flag = true;
						break;
					}
					while (idx < input.length() && input.charAt(idx) == '1')
						idx++;
					//모든 1을 지났다.
					if (idx == input.length()) {
						//1으로 끈나버림?
						flag = false;
						break;
					}
					//마지막이 0이다?
					if (idx == input.length() - 1) {
						flag = true;
						break;
					}
					//다음이 100형식이다??
					if (input.charAt(idx + 1) == '0') {
						if (input.charAt(idx - 2) == '1')
							input = input.substring(idx - 1);
						else {
							flag = true;
							break;
						}
					} else if (input.charAt(idx + 1) == '1') {
						input = input.substring(idx);
					}
					
				} else if (input.startsWith("01")) {
					input = input.substring(2);
				} else {
					flag = true;
					break;
				}
			}
			if (flag) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}

```