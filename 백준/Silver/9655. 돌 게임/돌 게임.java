import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int downCount=0, upCount=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 돌 개수
        // N이 짝수이면 무조건 창영이가 홀수이면 상근이가 이김
        System.out.println(N % 2 == 1 ? "SK" : "CY");

    }
}