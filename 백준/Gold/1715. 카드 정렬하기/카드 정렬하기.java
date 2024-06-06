import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    // 가장 작은 묶음 부터 : 10 20 30 40 -> 10+20 + 30+30 + 60+40 = 190
    // 가장 큰 묶음 부터 : 10 20 30 40 -> 40+30 + 70+20 + 90+10 = 260
    // 아무렇게나 : 10 20 30 40 -> 20+30 + 50+10 + 60+40 = 210
    // 가장 작은 묶음 부터 : 10 15 20 24 -> 10+15 + 20+24 + 25+44 = 138
    // 가장 큰 묶음 부터 : 10 15 20 24 -> 24+20 + 44+15 + 59+10 = 172
    // 아무렇게나 : 10 15 20 24 -> 15+20 + 35+24 + 59+10 = 163
    // 결론 : 가장 작은 것부터 더하는 게 최소 비교 횟수임.

    static PriorityQueue<Integer> pq;

    static int minComparison() {
        int min = 0;
        while(pq.size() != 1) {
            int bundleSum = pq.poll() + pq.poll();

            pq.add(bundleSum);
            min += bundleSum;
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 내림차순 우선순위 큐 데이터 입력
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int result = minComparison();

        System.out.println(result);
    }
}
