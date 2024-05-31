import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 1 || n > 500000) {
            System.out.println("잘못된 입력");
           return ;
        }

        long count = (long) n*(n-1)/2;

        System.out.println(count);

        System.out.println(2);

        br.close();
    }
}
