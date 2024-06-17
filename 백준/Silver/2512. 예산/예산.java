import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static long M;
    static long[] budgets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 지방 수
        String[] input = br.readLine().split(" "); // 지방 별 예산 입력

        budgets = new long[N]; // 지방 별 예산
        long sum = 0;
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(input[i]);
            sum += budgets[i];
        }

        M = Long.parseLong(br.readLine()); // 국가 예산

        Arrays.sort(budgets); // 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        if (sum <= M)
            sb.append(budgets[N-1]).append("\n"); // 마지막값이 최대값임.
        else

            sb.append(binarySearch(M)).append("\n");

        System.out.println(sb);

        br.close();
    }

    public static long binarySearch(long target) {
        long start = 0;
        long end = budgets[N-1]; // 최대값
        while(start <= end) {
            long mid = (start + end) / 2;
            long budgetSum = 0;
            // mid 값과 입력 예산들 중 최소 값을 찾아서 예산 적산
            for(long budget : budgets)
                budgetSum += Math.min(budget, mid);

            if(budgetSum < target)
                start = mid+1;
            else if (budgetSum == target) // 같으면 예산과 딱 맞는 상한 금액을 찾았으니 mid return
                return mid;
            else
                end = mid-1;
        }
        return end;
    }
}