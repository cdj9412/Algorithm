import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 데이터 개수

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine()); // 소설 장수
            // 최대 계산 시 integer 초과 할 가능성 있음
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++)
                pq.offer(Long.parseLong(st.nextToken())); // 소설 구성하는 파일 크기들

            long sum = 0;
            while (pq.size() != 1) {
                long firstValue = pq.poll();
                long secondValue = pq.poll();
                long mergeValue = firstValue + secondValue;
                pq.offer(mergeValue);
                sum += mergeValue;
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}