import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<String> inTunnel = new LinkedList<>();
        Queue<String> outTunnel = new LinkedList<>();

        // 입장 차량 저장
        for (int i = 0; i < N; i++)
            inTunnel.add(br.readLine());

        // 퇴장 차량 저장
        for (int i = 0; i < N; i++)
            outTunnel.add(br.readLine());
        
        br.close();

        int result = 0;
        while(!outTunnel.isEmpty()) {
            // 퇴장차량에서 데이터 꺼내기
            String outCar = outTunnel.poll();
            // 처음 입장한 차량과 퇴장차량을 비교해서 동일하면 입장 차량 Queue 에서 poll
            if(!inTunnel.peek().equals(outCar)) {
                // 다르면 추월로 판단 후 입장차량에서 지우기
                result++;
                inTunnel.remove(outCar);
            }
            else
                inTunnel.poll();
        }
        System.out.println(result);
    }
}
