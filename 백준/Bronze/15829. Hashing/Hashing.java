import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
     static final int r = 31;
     static final long M = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // a = 97
        int L = Integer.parseInt(br.readLine());
        String S = br.readLine();
        // M 이 10억 이상이라 long 사용
        long result = 0;
        long pow = 1; // 제곱연산이 들어가야 해서 1로 초기화
        for (int i = 0; i < L; i++) {
            result += (((S.charAt(i)-96) % M) * pow);
            pow = (pow * r) % M;
        }
        System.out.println(result % M);
    }
}