import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 내림차순 정렬 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int inputNum = Integer.parseInt(st.nextToken());
                pq.add(inputNum);
            }
        }
        // N 번째 이전 까지 데이터 삭제
        int beforeNum = N-1;
        for (int i = 0; i < beforeNum; i++)
            pq.remove();
        
        System.out.println(pq.poll());
        br.close();
    }
}
