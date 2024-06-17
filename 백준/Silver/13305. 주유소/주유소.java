import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] dist;
    static long[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시 수

        // 도시 사이의 거리 입력
        dist = new long[N-1];
        String[] inputDistance = br.readLine().split(" ");
        for (int i = 0; i < N-1; i++)
            dist[i] = Long.parseLong(inputDistance[i]);

        // 도시의 기름 가격 입력
        price = new long[N];
        String[] inputPrice = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            price[i] = Long.parseLong(inputPrice[i]);

        System.out.println(checkMinPrice());
        br.close();
    }

    public static long checkMinPrice() {
        long sumPrice = 0;
        long minPrice = price[0]; // 제일 왼쪽 도시의 가격으로 초기화

        int distLength = dist.length;
        for(int i = 0; i < distLength; i++) {
            if(price[i] < minPrice)
                minPrice = price[i];

            // 갱신된 최소값과 거리 곱해서 총 최소 비용에 적산
            sumPrice += (minPrice*dist[i]);
        }

        return sumPrice ;
    }
}