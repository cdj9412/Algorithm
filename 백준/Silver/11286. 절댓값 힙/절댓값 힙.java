import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static StringBuilder sb ;
    static PriorityQueue<Integer> pq ;

    static void priorityQueueRuleSet(){
        // priority queue 정렬 전략 설정 방법
        // priority queue 정렬 전략 설정은 하는 방법을 몰라서 검색을 통해 알아냄.
        pq = new PriorityQueue<>((obj1, obj2) -> {
            // 파라미터는 기본적으로 object 임. -> int 로 사용하려면 obj -> string -> int
            int x = Integer.parseInt(obj1.toString());
            int y = Integer.parseInt(obj2.toString());
            int absX = Math.abs(x);
            int absY = Math.abs(y);

            // 두 값을 비교할 때 x 에 우선 순위를 주고 싶으면 음수 아니면 양수 반환
            if (absX < absY)
                return -1;
            else if (absX > absY)
                return 1;
            else {
                // 절댓값이 가장 작은 값이 여러개 일 때 가장 작은 수를 출력
                if (x < y)
                    return -1;
                else
                    return 1;
            }
        });

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // priorityQueue 규칙 설정
        priorityQueueRuleSet();

        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                // 비어있으면 0 출력
                if (pq.isEmpty())
                    sb.append("0\n");
                // 아니면 규칙에 의해 현재 큐에 있는 가장 우선순위가 높아진 값(가장 작은 값) 출력
                else
                    sb.append(pq.poll()).append("\n");
            }
            else
                pq.offer(input);
        }
        System.out.println(sb);
        br.close();
    }
}