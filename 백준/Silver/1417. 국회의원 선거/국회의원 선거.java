import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    // 최종 시간 복잡도 : O(NlogN)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 후보 한명일 경우
        if (N == 1) {
            System.out.println(0);
            br.close();
            return;
        }

        int me = Integer.parseInt(br.readLine()); // 첫번째 다솜
        int loopCount = N-1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < loopCount; i++) //O(N)
            pq.offer(Integer.parseInt(br.readLine())); //O(logN)

        int buyCount = 0;
        while(!pq.isEmpty()) { //O(N)
            int voteMax = pq.poll();
            if (voteMax < me)
                break;

            voteMax--; me++; buyCount++;
            pq.offer(voteMax); //O(logN)
        }
        System.out.println(buyCount);
        br.close();
    }
}