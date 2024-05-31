import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 제한 조건
        if (n < 1 || n > 500000) {
            System.out.println("잘못된 입력");
            return ;
        }
        long count = (long) n*(n-1)*(n-2)/(3*2);

        // 수행 횟수 출력
        System.out.println(count);

        // MenOfPassion 의 수행횟수 다항식 표현 시 최고차항 차수
        // O(n^3) 시간 복잡도 이므로 최고차수는 3임.
        System.out.println(3);

        br.close();
    }
}
