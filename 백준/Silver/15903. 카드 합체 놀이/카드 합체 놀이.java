import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 오름차순 우선 순위 큐 선언
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 데이터 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            pq.add(Long.parseLong(st.nextToken()));

        for (int i = 0; i < m; i++) {
            long minFirst = pq.poll();
            long minSecond = pq.poll();
            long mergeNum = minFirst + minSecond;
            pq.offer(mergeNum);
            pq.offer(mergeNum);
        }

        long result = 0;
        while (!pq.isEmpty())
            result += pq.poll();

        System.out.println(result);
        br.close();
    }
}