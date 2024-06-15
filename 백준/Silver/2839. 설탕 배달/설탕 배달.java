import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;
        while(N > 0) {
            // 5로 나눠지면 바로 출력
            if (N % 5 == 0) {
                count += N/5;
                System.out.println(count);
                return;
            }
            // N이 4나 7이면 아예 나눌 수 없음
            if(N == 4 || N == 7) {
                System.out.println(-1);
                return ;
            }
            N-=3; // 5로 나눠질때 까지 3kg 봉지 하나씩 추가
            count++;
        }
        System.out.println(count);
    }

}