import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 크기
        int[] arr = new int[N]; // 받은 수열
        // f(n) = max(f(x)) / 0 <= x < n / g(n) > g(x)

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);

        int[] memo = new int[N];
        memo[0] = 1;
        for(int i = 1; i < N; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) 
                    memo[i] = Math.max(memo[i], memo[j] + 1);
            }
        }

        int answer = Arrays.stream(memo).max().getAsInt();
        System.out.println(answer);
    }
}