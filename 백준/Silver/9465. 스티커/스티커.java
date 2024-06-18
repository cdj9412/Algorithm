import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // dp 문제
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 1줄의 스티커 수
            int[][] stickers = new int[2][n+1];
            for (int j = 0; j < 2; j++) {
                String[] input = br.readLine().split(" "); // 스티커의 점수
                for (int k = 1; k <= n; k++)
                    stickers[j][k] = Integer.parseInt(input[k-1]);
            }
            sb.append(dp(stickers, n)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int dp(int[][] stickers, int n) {
        int[][] dp = new int[2][n+1];
        dp[0][1] = stickers[0][1];
        dp[1][1] = stickers[1][1];

        // 상하좌우 못쓰니까 대각 아래나 위의 전, 전전꺼 중에 큰거 + 내위치 값
        for (int i = 2; i < n+1; i++) {
            dp[0][i] =  Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
            dp[1][i] =  Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
        }
        return Math.max(dp[0][n], dp[1][n]);
    }
}