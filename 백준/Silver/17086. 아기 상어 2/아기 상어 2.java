import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static class SharkNode {
        int row;
        int col;
        public SharkNode(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N,M;
    static int[][] space ;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static Queue<SharkNode> sharkNodes = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 공간의 행
        M = Integer.parseInt(input[1]); // 공간의 열

        space = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(line[j]);
                if (space[i][j] == 1)
                    sharkNodes.offer(new SharkNode(i, j));
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        int maxDistance = 0;
        // 거리 저장용 배열
        int[][] distances = new int[N][M];

        while (!sharkNodes.isEmpty()) {
            SharkNode current = sharkNodes.poll();

            // 8 방향 돌면서 상어 있는지 체크
            for (int i = 0; i < 8; i++) {
                int nextRow = current.row + dx[i];
                int nextCol = current.col + dy[i];

                // 인덱스를 넘으면 넘기고
                if (checkOverFlow(nextRow, nextCol)) continue ;

                // 아직 방문하지 않은 칸이면
                if (space[nextRow][nextCol] == 0 && distances[nextRow][nextCol] == 0) {
                    distances[nextRow][nextCol] = distances[current.row][current.col] + 1;
                    sharkNodes.offer(new SharkNode(nextRow, nextCol));
                    maxDistance = Math.max(maxDistance, distances[nextRow][nextCol]);
                }
            }
        }
        return maxDistance;
    }

    public static boolean checkOverFlow(int row, int col) {
        return (row < 0 || row >= N || col < 0 || col >= M);
    }
}
