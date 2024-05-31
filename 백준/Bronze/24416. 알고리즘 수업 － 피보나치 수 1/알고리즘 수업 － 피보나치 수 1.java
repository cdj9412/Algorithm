import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int recursionCnt = 0;
    static int dynamicCnt = 0;
    static int[] fibo ;

    // 피보나치 수 재귀 호출 코드
    public static int fib(int n) {
        if (n == 1 || n == 2){
            recursionCnt++;
            return 1;
        }
        else
            return fib(n - 1) + fib(n - 2);
    }

    // 피보나치 수 동적 프로그래밍 코드
    public static int fibonacci(int n) {
        fibo[0] = 1;
        fibo[1] = 1;
        for (int i = 2; i < n; i++) {
            dynamicCnt++;
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[n-1];
    }

    public static void  main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 제한 조건
        if (n < 5 || n > 40) {
            System.out.println("잘못된 입력");
            return ;
        }

        fibo = new int[n];
        fib(n);
        fibonacci(n);

        // 재귀의 경우 피보나치 수의 경우의 수만큼 반복함.
        // 동적 프로그래밍은 n-2 만큼만 반복함.
        // 동적 프로그래밍을 자주 활용해야할 듯?
        System.out.println(recursionCnt + " " + dynamicCnt);

        br.close();
    }
}