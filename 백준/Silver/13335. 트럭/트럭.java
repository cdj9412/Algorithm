import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int n,w,L;

    // truck 담을 queue, 다리위에서 트럭이 이동하는 걸 체크할 queue 두개로 구현하면 될듯?
    // 전체 시간 복잡도 : O(w+n)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]); // 트럭 수
        w = Integer.parseInt(input[1]); // 다리 길이
        L = Integer.parseInt(input[2]); // 다리 최대 하중

        String[] truck = br.readLine().split(" ");
        Queue<Integer> trucks = new ArrayDeque<>();
        for (int i = 0; i < n; i++) // O(n)
            trucks.offer(Integer.parseInt(truck[i]));

        // 다리 길이 만큼 queue 에 무게(0) 추가
        // 칸마다 쌓여있는 무게
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) // O(w)
            bridge.add(0);

        int counter = 0;
        int weightSum = 0;
        // O(w+n) w 만큼 반복을 돌리지만 트럭이 다 빠져나갈 때까지 돌려야 해서 +n
        while (!bridge.isEmpty()) { 
            counter++;
            weightSum -= bridge.poll(); // 다리 끝 값 빼기
            if (!trucks.isEmpty()) {
                // 기존 다리에 올라와 있던 무게와 들어올 트럭의 무게 합쳐서 최대 무게와 비교
                if(trucks.peek() + weightSum <= L) {
                    weightSum += trucks.peek();
                    bridge.offer(trucks.poll());
                }
                else
                    bridge.offer(0);
            }
        }
        System.out.println(counter);
    }
}