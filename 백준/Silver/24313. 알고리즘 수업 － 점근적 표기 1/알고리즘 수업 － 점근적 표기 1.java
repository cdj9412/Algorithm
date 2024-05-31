import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        // 제한조건
        if (Math.abs(a1) > 100 || Math.abs(a0) > 100) {
            System.out.println("잘못된 입력");
            return ;
        }

        int c = Integer.parseInt(br.readLine());
        // 제한조건
        if (c < 1 || c > 100) {
            System.out.println("잘못된 입력");
            return ;
        }

        int n0 = Integer.parseInt(br.readLine());
        // 제한조건
        if (n0 < 1 || n0 > 100) {
            System.out.println("잘못된 입력");
            return ;
        }

        //O(g(n)) 조건문으로 변환
        // 모든 n>= n0 이므로 n은 n0로 치환
        // O(n) = O(g(n))을 만족하는 것을 전제로 판단하는 것이기 때문에 g(n) = n
        // 위의 두 전제를 토대로 g(n)또한 n0로 판단
        // f(n) = a1*n0 + a0 <= c * n0
        // 한가지 추가
        // a0가 음수일 때, a1이 c보다 크게 되면 n의 값에 따라 결과가 달라지는 현상이 발생함.
        // 따라서 a1이 c 보다 작거나 같다는 조건이 추가되어야함
        if(((a1 * n0) + a0 <= c * n0) && a1 <= c )
            System.out.println(1);
        else
            System.out.println(0);

        br.close();
    }
}
