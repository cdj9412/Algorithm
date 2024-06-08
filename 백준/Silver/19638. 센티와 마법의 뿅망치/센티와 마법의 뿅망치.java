import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 최종 시간 복잡도 : O(NlogN)
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 거인의 수
        int Hcenti = Integer.parseInt(st.nextToken()); // 센티의 키
        int T = Integer.parseInt(st.nextToken()); // 망치 횟수 제한

        PriorityQueue<Integer> heights = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) { // N
            int G = Integer.parseInt(br.readLine()); // 거인의 키
            heights.offer(G);
        }

        StringBuilder sb = new StringBuilder();
        int useCount = 0;
        // 큐에 데이터가 존재하고, 망치 사용횟수가 남았고, 가장 키 큰 거인이 센티보다 클 때만 반복
        while (!heights.isEmpty() && T > 0 && heights.peek() >= Hcenti) { // N
            int highest = heights.poll();
            // 가장 큰 키가 1이면 종료
            if (highest == 1) {
                heights.offer(highest); //logN
                break;
            }

            // 망치 사용
            T--; useCount++;
            int changeHeight = highest / 2;
            heights.offer(changeHeight); //logN
        }

        int largestRemaining = heights.isEmpty() ? 0 : heights.peek();
        if (largestRemaining < Hcenti)
            sb.append("YES\n").append(useCount);
        else
            sb.append("NO\n").append(largestRemaining);

        System.out.println(sb);
    }
}