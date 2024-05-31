import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(n);

        // MenOfPassion 의 수행횟수 다항식 표현 시 최고차항 차수
        // 이건 구현하는게 아니라 출력하는거 같은데....
        // 아무리봐도 반복문 하나라서 시간복잡도가 O(n)임 따라서 차수는 1로 고정될 수 밖에 없음.
        System.out.println(1);

    }
}
