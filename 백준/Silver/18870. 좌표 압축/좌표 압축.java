import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    // 총 시간 복잡도 : O(N + (NlogN) + N + N)
    // 빅오 표기법에서 가장 큰 항만 고려 : N + NlogN + N + N  = NlogN
    // 최종 시간 복잡도 : O(N * logN)
    // 좌표 압축...? 예제 보면 그냥 0부터 시작하는 순위 출력 같은데 가장 낮을 수록 0
    // 공동 순위가 있어도 다음 순위는 바로 다음 값이지 공동 순위 좌표만큼 밀려나지 않는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // int 배열 두 개를 선언해서 기존 순서를 유지할 배열과 정렬을 통해 순위를 측정할 배열 두 개로 시작
        int[] input = new int[N];
        int[] inputSort = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) // O(N)
            input[i] = inputSort[i] = Integer.parseInt(st.nextToken());

        // 오름차순으로 정렬 시켜서 이걸로 순위는 매기기
        Arrays.sort(inputSort); // O(N*logN)

        // 중복된 값은 같은 순위를 가지기 때문에 해쉬 맵에 넣어도 됨
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0; // 순위 입력용
        for (int sortValue : inputSort) { // O(N)
            if (!rankMap.containsKey(sortValue)) {
                rankMap.put(sortValue, rank); // O(1)
                rank++; // 중복값 나와도 순위를 늘리면 안되기 때문에 여기서 증가
            }
        }

        StringBuilder sb = new StringBuilder();
        // rankMap 에 있는 key 에 대한 value 출력
        for (int inputValue : input) // O(N)
            sb.append(rankMap.get(inputValue)).append(" "); // O(1)

        System.out.println(sb);
    }
}