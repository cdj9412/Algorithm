import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            times[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(times); // 오름차순 정렬

        int result = 0;
        int accumulation = 0; // 배열 요소들의 누적 값
        for (int i = 0; i < N; i++) {
            result += (accumulation + times[i]);
            accumulation += times[i];
        }
        System.out.println(result);
        br.close();
    }
}