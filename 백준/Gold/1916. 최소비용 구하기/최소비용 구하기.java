import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 최종 시간 복잡도 : O((N + M))
    static int N,M;
    static class Node {
        int end;
        int pay;
        public Node(int end, int pay) {
            this.end = end;
            this.pay = pay;
        }
    }
    static ArrayList<ArrayList<Node>> nodes;
    static int[] payments;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시 수
        M = Integer.parseInt(br.readLine()); // 버스 수
        // 초기화
        nodes = new ArrayList<>();
        for (int i = 1; i <= N+1; i++)
            nodes.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int S = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            int P = Integer.parseInt(input[2]);
            nodes.get(S).add(new Node(E, P));
        }
        String[] input = br.readLine().split(" ");
        int resultS = Integer.parseInt(input[0]);
        int resultE = Integer.parseInt(input[1]);
        dijkstra(resultS);

        System.out.println(payments[resultE]);
    }
    public static void dijkstra(int start) {
        payments = new int[N+1]; // visited 역할 같이 수행
        Arrays.fill(payments,Integer.MAX_VALUE); // 최소 금액이니까 max 로 초기화
        payments[start] = 0;

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()){
            Node currentNode = q.poll();
            int currentPay = currentNode.pay;
            
            // 현재 입력된 비용이 이미 작다면 패스
            if(currentPay > payments[currentNode.end]) continue;

            for (Node nextNode : nodes.get(currentNode.end)) {
                int nextCity = nextNode.end;
                int nextPay = nextNode.pay;
                // 현재 도시까지의 비용과 다음 도시까지 비용을 합친게 이전에 확인했던 비용보다 작으면 업데이트
                if (payments[nextCity] > nextPay + currentPay) {
                    payments[nextCity] = nextPay + currentPay;
                    q.add(new Node(nextCity, nextPay+currentPay));
                }
            }
        }
    }
}