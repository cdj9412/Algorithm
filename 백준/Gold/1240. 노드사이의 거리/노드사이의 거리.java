import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class nodeInfo {
        int node;
        int distance;
        nodeInfo(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    static int N,M;
    static ArrayList<ArrayList<nodeInfo>> nodes;
    static boolean[] visited;
    static StringBuilder sb;

    // 트리노드 이지만 거리는 역순으로 검색할 수 있으니 방향성이 없다고 간주하고 양방향의 거리와 노드 추가

    // 최종 시간 복잡도 : O(N+M)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 전체 노드 수
        M = Integer.parseInt(st.nextToken()); // 거리를 알고 싶은 노드 쌍의 수

        nodes = new ArrayList<>();
        for (int i = 1; i <= N+1; i++)
            nodes.add(new ArrayList<>());


        for (int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 노드 1
            int v = Integer.parseInt(st.nextToken()); // 노드 2
            int d = Integer.parseInt(st.nextToken()); // u v 사이의 거리
            nodes.get(u).add(new nodeInfo(v,d));
            nodes.get(v).add(new nodeInfo(u,d)); // 방향성 없으므로 추가

        }

        sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 거리 확인 노드 1
            int y = Integer.parseInt(st.nextToken()); // 거리 확인 노드 2
            BFS(x,y);
        }

        System.out.println(sb);
        br.close();
    }

    public static void BFS(int start, int end) {
        ArrayDeque<nodeInfo> queue = new ArrayDeque<>();
        visited = new boolean[N+1];

        queue.add(new nodeInfo(start,0));
        visited[start] = true ;

        int[] accumulateDistance = new int[N+1];

        while (!queue.isEmpty()) {
            nodeInfo current = queue.poll();

            for (nodeInfo next : nodes.get(current.node)) {
                if (!visited[next.node]) {
                    // start 부터 nextNode 까지의 거리 누적
                    accumulateDistance[next.node] += next.distance + accumulateDistance[current.node];
                    if (next.node == end) {
                        sb.append(accumulateDistance[next.node]).append("\n");
                        return;
                    }
                    visited[next.node] = true;
                    queue.add(next);
                }
            }
        }
    }
}