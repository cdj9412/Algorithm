import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N개 센서
        // 고속도로 평면상의 직선
        // 센서들은 직선위에 한 기점인 원점으로 부터 정수 거리 위치에 놓여 있음
        // 좌표 정수 하나 / 집중국의 수신 가능 영역의 길이 : 0이상
        // 문제가 무슨말이지..?
        // 센서위치에 수신기를 설치할 수 있고 전체 센서가 수신기에 닿아야하는거면
        // 인접 센서와의 거리는 pq에 저장하고 센서 수 - 집중국 수 만큼 뽑아내기?
        // 일단 K가 N보다 크거나 같으면 0출력하고 끝내면 될거고

        N = Integer.parseInt(br.readLine()); // 센서의 개수
        K = Integer.parseInt(br.readLine()); // 집중국의 개수
        if(N <= K) {
            System.out.println(0);
            br.close();
            return;
        }

        int[] sensor = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            sensor[i]= Integer.parseInt(input[i]);

        Arrays.sort(sensor);
        System.out.println(getDistanceMin(sensor));

    }
    public static int getDistanceMin(int[] sensor){
        PriorityQueue<Integer> distance = new PriorityQueue<>();
        int length = sensor.length-1;
        for(int i = length; i >= 1; i--){
            int dis = sensor[i] - sensor[i-1];
            distance.add(dis);
        }

        int sum = 0;
        for(int i = 0; i < N-K; i++)
            sum += distance.poll();

        return sum;
    }
}