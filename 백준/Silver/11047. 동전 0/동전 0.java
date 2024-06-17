import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, K;
    static int[] coins;
    // 그리디
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 동전 종류
        K = Integer.parseInt(input[1]); // 가치
        coins = new int[N];
        for (int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine());

        System.out.println(checkMin());
        br.close();
    }

    public static int checkMin(){
        Arrays.sort(coins); // 오름차순 정렬
        int coinCount = 0;
        int coinLength = coins.length;
        // 정렬된 배열을 큰 단위의 동전(?) 부터 나누기
        for (int i = coinLength - 1; i >= 0; i--) {
           if (K == 0)
               break;

           coinCount += K / coins[i];
           K %= coins[i];
        }
        return coinCount;
    }
}