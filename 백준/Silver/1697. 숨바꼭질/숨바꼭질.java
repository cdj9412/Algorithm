import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static final int maxLocation = 100001;
    static int N,K;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        // 최단 거리 BFS
        // 걷기 : X -> 1초 후 X-1 / X+1
        // 순간이동 : X -> 1초 후 2X
        // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈이 점 위치
        K = Integer.parseInt(st.nextToken()); // 동생 점 위치

        if (N==K) {
            System.out.println(0);
            return;
        }

        BFS(N,K);
    }

    public static void BFS(int start, int end) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited = new int[maxLocation];
        visited[start] = 1;
        while (!queue.isEmpty()) {
            int currentLocation = queue.poll();

            // 무조건 한방향으로 가는게 빠른게 아니므로 전부 다 해봐야 함
            for(int i = 0; i < 3; i++) {
                int nextLocation = 0;
                switch(i) {
                    case 0: nextLocation = currentLocation + 1; break;
                    case 1: nextLocation = currentLocation - 1; break;
                    case 2: nextLocation = currentLocation * 2; break;
                    default : break;
                }
                
                // OutOfBound check
                if(nextLocation < 0 || nextLocation >= maxLocation)
                    continue;

                if (nextLocation == end) {
                    System.out.println(visited[currentLocation]);
                    return;
                }

                // nextLocation 방문 내역이 없으면 증가
                if(visited[nextLocation] == 0) {
                    queue.add(nextLocation);
                    visited[nextLocation] = visited[currentLocation] + 1;
                }
            }

        }
    }
}