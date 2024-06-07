import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    // 총 시간 복잡도 : O(N + N)
    // 빅오 표기법에서 가장 큰 항만 고려 : N + N  = N
    // 최종 시간 복잡도 : O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 정렬해줄 필요가 없고 중복이 없는 입력이니 HashSet 에 카드 전체 저장
        HashSet<Integer> cardSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) // O(N)
            cardSet.add(Integer.parseInt(st.nextToken())); // O(1)

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) { // O(N)
            int compareNumber = Integer.parseInt(st.nextToken());
            if(cardSet.contains(compareNumber)) // O(1) 최악 O(N) 인데.. 해시충돌이 일어날 만한 구석은 딱히 없음.
                sb.append("1").append(" ");
            else
                sb.append("0").append(" ");
        }

        sb.deleteCharAt(sb.length()-1); // 마지막 공백 제거
        sb.append("\n");
        System.out.println(sb);
        br.close();
    }
}