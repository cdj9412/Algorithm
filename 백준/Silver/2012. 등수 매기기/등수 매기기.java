import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 최종 시간 복잡도 : O(N)
    static int N;
    static int[] expectRank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        expectRank = new int[N];
        for (int i = 0; i < N; i++)  //O(N)
            expectRank[i] = Integer.parseInt(br.readLine());

        System.out.println(minDissatisfaction());
    }

    public static long minDissatisfaction(){
        // 순서대로 정렬하고
        Arrays.sort(expectRank);
        long dissatisfaction = 0;

        // 어차피 동순위 없으니 정렬된 예상순위에서 실제 등수를 뺀 절대값을 더하면 됨
        for(int i = 1; i <= N; i++)
            dissatisfaction += Math.abs(expectRank[i-1] - i);

        return dissatisfaction;
    }
}