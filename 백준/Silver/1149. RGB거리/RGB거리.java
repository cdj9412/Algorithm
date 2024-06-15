import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static class Cost {
        int R;
        int G;
        int B;
        public Cost(int R, int G, int B) {
            this.R = R;
            this.G = G;
            this.B = B;
        }
    }
    static Cost[] costs ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 집 수
        costs = new Cost[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int inputR = Integer.parseInt(input[0]);
            int inputG = Integer.parseInt(input[1]);
            int inputB = Integer.parseInt(input[2]);
            costs[i] = new Cost(inputR, inputG, inputB);
        }

        int minResult = dp();
        System.out.println(minResult);
        br.close();
    }

    public static int dp() {
        // 두번째 집부터 이전 집의 다른색상 중 최소값을 더하기
        // 이러면 마지막 집들에 양옆과 색상이 다른 비용의 최소 합들을 알 수 있음.
        // costs[i]의 각각의 요소가 기존 값 저장과 메모이제이션 배열 역할을 같이 함.
        for (int i = 1; i < N; i++) {
            costs[i].R += Math.min(costs[i-1].G, costs[i-1].B);
            costs[i].G += Math.min(costs[i-1].B, costs[i-1].R);
            costs[i].B += Math.min(costs[i-1].R, costs[i-1].G);
        }
        return Math.min(costs[N-1].R, Math.min(costs[N-1].G, costs[N-1].B));
    }
}