import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 데이터 String Token 에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());

        // String Token 값을 StringBuilder 에 저장
        StringBuilder A = new StringBuilder(st.nextToken());
        StringBuilder B = new StringBuilder(st.nextToken());

        // reverse 함수로 뒤집어진 String 을 int 로 바꿔 저장
        int reverseA = Integer.parseInt(A.reverse().toString());
        int reverseB = Integer.parseInt(B.reverse().toString());

        // 두 값중 최대값 출력
        System.out.println(Math.max(reverseA, reverseB));

    }
}
