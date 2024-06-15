import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int last = 10007;
    static int N;
    // 2xn 크기 직사각형 채우는 방법 - 피보나치 같은데 / 돌리기 안되겠지?
    /*
     * 2x1 = A / 1x2 = B
     * n=1 : A 1
     * n=2 : Ax2 / Bx2 2
     * n=3 : Ax3 / Bx2 A / A Bx2 3
     * n=4 : Ax4 / Bx2 Ax2 / A Bx2 A / Ax2 Bx2 / Bx4 5
     * n=5 : Ax5 / Bx2 Ax3 / A Bx2 Ax2 / Ax2 Bx2 A / Ax3 Bx2 / Bx4 A / A Bx4 / Bx2 A Bx2 8
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(dp(N));

    }

    public static int dp(int n) {
        int[] memo = new int[1001]; // n+1로 초기화 시 1 들어오면 out of bound
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2])%10007;
        }
        return memo[n];
    }
}