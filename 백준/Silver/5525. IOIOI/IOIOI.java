import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(N < 1 || N > 1000000 || M < (2*N)+1 || M > 1000000) {
            System.out.println("잘못된 입력");
            br.close();
            return ;
        }

        String S = br.readLine();

        // PN 생성
        String PN = "IOI";
        PN = PN + "OI".repeat(N-1);

        int result = 0;

        // 순회 시작
        for(int i = 0; i < M - (2 * N); i++) {
            // OIOIOI 에서
            // IOI 로 시작되면 인덱스 하나 더 뒤로 가도 됨. O 패스
            if(S.startsWith(PN, i)){
                result++;
                i++;
            }
        }
        System.out.println(result);
    }
}
