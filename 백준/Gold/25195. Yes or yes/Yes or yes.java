import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // DFS 로 구현하고, 전체 정점을 반복해서 돌면서 한번이라도 팬을 만나지 않는 경로가 있다면 Yes 출력하도록하기
    // 최종 시간 복잡도 : O(N+M)
    static int N, M, S ;
    static boolean[] visited;
    static List<Integer>[] travel ;
    static ArrayList<Integer> fanLocation ;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 전체 노드 수
        M = Integer.parseInt(st.nextToken()); // 간선 정보 수

        visited = new boolean[N+1];
        travel = new List[N+1];
        for(int i = 1; i <= N; i++)
            travel[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 선행 노드
            int v = Integer.parseInt(st.nextToken()); // 후행 노드
            travel[u].add(v);
        }

        S = Integer.parseInt(br.readLine()); // 팬클럽 수
        fanLocation = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++)
            fanLocation.add(Integer.parseInt(st.nextToken()));

        boolean meet = BFS(1);
        System.out.println(meet ? "Yes" : "yes");
    }

    public static boolean BFS(int start) {
        // 출발지에 팬클럽이 있는 경우
        if (fanLocation.contains(start))
            return true;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true ;

        while (!queue.isEmpty()) {
            int currentLocation = queue.poll();

            // 다음 행선지가 없을 경우 false 리턴
            if (travel[currentLocation].isEmpty())
                return false;

            for (int nextLocation : travel[currentLocation]) {
                if (!visited[nextLocation]) {
                    // 다음 행선지가 팬의 위치일 경우 넘어가기
                    if (fanLocation.contains(nextLocation))
                        continue;
                    queue.add(nextLocation);
                    visited[nextLocation] = true;
                }
            }
        }
        return true;
    }
}