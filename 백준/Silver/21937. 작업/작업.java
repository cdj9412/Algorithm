import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 이전에 필요한 작업이 여러개면 전부 수행되고 나서 목표 작업을 수행 할 수 있음.
    // 그럼 DFS 로 구현하고, 목표 작업을 시작으로 돌려서 구현하면 될 것 같음.
    // 최종 시간 복잡도 : O(N+M)
    static int N, M, X;
    static List<Integer>[] works;
    static boolean[] completed;
    static int priorWorkCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 전체 작업의 수
        M = Integer.parseInt(st.nextToken()); // 작업 순서 정보 개수

        // 각 작업에 대한 필수 선행 작업 관리용 리스트
        works = new List[N + 1];
        for(int i = 1; i <= N; i++)
            works[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 선행 작업
            int B = Integer.parseInt(st.nextToken()); // 후행 작업
            works[B].add(A); // 후행 작업을 기준으로 선행작업 저장
        }
        X = Integer.parseInt(br.readLine());
        DFS();
        System.out.println(priorWorkCount);
    }

    public static void DFS() {
        completed = new boolean[N + 1];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(X);

        while (!stack.isEmpty()) {
            int targetWork = stack.pop();
            for (int priorWork : works[targetWork]) {
                // 예를 들어 4의 사전작업이 2,3 | 2와 3의 사전 작업이 1이면
                // targetWork 가 2 일 때 1을 카운팅 하면 3에서는 할 필요 없음.
                if (completed[priorWork])
                    continue;
                priorWorkCount++ ; // 사전 작업 개수 카운팅
                completed[priorWork] = true ;
                stack.push(priorWork);

            }
        }
    }
}