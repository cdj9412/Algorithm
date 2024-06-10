import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // DFS, BFS 상관없이 써도 될 듯 우선순위가 따로 있는것도 아니고 해당되는 것만 체크하면 됨.
    // 앞에서 BFS 로 구현 했으니 여기선 DFS 로 구현 해보기
    // 최종 시간 복잡도 : O(C+N)
    static int C,N;
    static int infectionCount = 0;
    static final int start = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        
        // 감염 여부 관리용 배열
        boolean[] infected = new boolean[C+1];

        // 각 컴퓨터에 대한 직접 연결 관리용 리스트
        List<Integer>[] computers = new List[C+1];
        for (int i = 1; i <= C; i++)
            computers[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int frontPC = Integer.parseInt(st.nextToken());
            int backPC = Integer.parseInt(st.nextToken());
            computers[frontPC].add(backPC);
            computers[backPC].add(frontPC); // 방향성이 없으므로 양방향 연결 처리 추가
        }
        dfs(computers, infected);
        System.out.println(infectionCount);
        br.close();
    }

    public static void dfs(List<Integer>[] computers, boolean[] infected) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        infected[start] = true;

        while (!stack.isEmpty()) {
            int currentPC = stack.pop();

            for (int PC : computers[currentPC]) {
                // 아직 감염되지 않았으면 감염 처리 후 카운트 늘리기
                if (!infected[PC]) {
                    stack.push(PC);
                    infected[PC] = true;
                    infectionCount++;
                }
            }
        }
    }
}