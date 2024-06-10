import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 최종 시간 복잡도 : O(N^2)
    static int N, M, K, X ;
    static ArrayList<Integer> result ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        K = Integer.parseInt(st.nextToken()); // 최단 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호


        List<Integer>[] cities = new List[N+1]; // 모든 도시들에 대한 단방향 도로 정보
        for (int i = 1; i <= N; i++)
            cities[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) { // O(n)
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            cities[A].add(B);
        }

        result = new ArrayList<>();
        bfs(cities); // O(N^2)
        Collections.sort(result); // 정렬
        StringBuilder sb = new StringBuilder();
        for(int currentCity : result){ // O(n)
            sb.append(currentCity).append("\n");
        }
        System.out.println(result.isEmpty() ? -1 : sb);
    }

    public static void bfs(List<Integer>[] cities) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(X);
        int[] distance = new int[N+1];
        Arrays.fill(distance, -1); // 최단 거리의 유무를 판단하기 위해 전부 -1로 초기화
        distance[X] = 0; // 출발 도시는 0으로 초기화

        while (!queue.isEmpty()) { // O(n)
            int currentCity = queue.poll();
            if(distance[currentCity] == K) {
                result.add(currentCity);
            }

            // 현재 정점과 인접한 모든 정점을 확인
            for(int nextCity : cities[currentCity]) {
                if (distance[nextCity] != -1) continue;  // 이미 최단 거리가 있을 경우 넘기기
                distance[nextCity] = distance[currentCity] + 1; // 이전 도시의 경우의 수 + 1
                queue.add(nextCity); // 큐에 추가
            }
        }
    }
}