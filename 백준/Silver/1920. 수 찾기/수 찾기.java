import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 저장 순서에 딱히 구애 받지 않고 중복을 방지하고, contains 메서드를 사용하기 위해
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++)
            set.add(Integer.parseInt(st.nextToken()));

        StringBuilder result = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            if(set.contains(Integer.parseInt(st.nextToken())))
                result.append("1\n");
            else
                result.append("0\n");
        }
        System.out.println(result);
        br.close();
    }
}