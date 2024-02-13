// 1 <=N <=50 단어의 개수
// 1 <=K <=26 가르칠수있는 단어의 개수
// 8<= 단어의 길이 <=15   (anta tica를 제외한 단어의 길이는 0~7)
// 5개 글자는 무조건 가르쳐야함 (atnic)

// 출력: 읽을수 있는 단어 개수의 최댓값



// 최대 시간복잡도 : 단어마다 모르는 알파벳 7개 * 글자의 개수 50개 중에서 26개를 고름
// 350C26 +350C25 + 350C24.......350C0 -> 가능??
package week03.조수훈;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1062 {

    static int N;
    static int K;
    static int[] words;
    static int result = 0;

    public static void combination(int r, int start, int mask) {
        if (r == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if ((words[i] & mask) == words[i]) {
                    count++;
                }
            }
            result = Math.max(result, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if ((mask & (1 << i)) == 0) {
                combination(r + 1, i + 1, mask | (1 << i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new int[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (char ch : word.toCharArray()) {
                if (ch != 'a' && ch != 'n' && ch != 't' && ch != 'i' && ch != 'c') {
                    words[i] |= (1 << (ch - 'a'));
                }
            }
        }

        // 항상 배워야하는 atnic은 비트 표현에서 제외
        int mask = (1 << ('a' - 'a')) | (1 << ('n' - 'a')) | (1 << ('t' - 'a')) | (1 << ('i' - 'a')) | (1 << ('c' - 'a'));

        // K가 5 미만인 경우 모든 단어를 읽을 수 없음
        if (K < 5) {
            System.out.println(0);
            return;
        }

        // K가 26 이상이면 모든 단어를 읽을 수 있음
        if (K >= 26) {
            System.out.println(N);
            return;
        }

        combination(0, 0, mask);
        System.out.println(result);
    }
}
