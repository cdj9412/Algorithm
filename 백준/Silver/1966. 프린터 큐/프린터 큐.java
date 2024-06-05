import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 문서의 중요도 저장용 큐 (초기 인덱스 값, 중요도)
    // 처음엔 Queue 로 생성하여 문제를 풀려고 했지만
    // 최대값을 구하는 과정에서 특정요소에 접근하려면 LinkedList 로 구현했어야 했음.
    static LinkedList<int[]> document;
    static StringBuilder result;

    static void priorityCheck(int M) {
        // M의 인쇄 순서
        int count = 0;

        // 최대인 요소가 가장 앞에 오면 큐에서 빼고 인쇄 순서를 늘리고
        // 원하는 인덱스의 문서가 맨 앞에 도착할 시 종료
        while (!document.isEmpty()) {
            // queue 의 가장 앞 요소 빼기
            int[] first = document.poll();
            // first 가 가장 큰 요소인지 체크용
            boolean isMax = true;

            // 큐에 남은 모든 요소와 비교하여 중요도 체크
            for (int i = 0; i < document.size(); i++) {
                // 큐의 요소 중에 처음 값보다 큰 값이 있다면
                if(first[1] < document.get(i)[1]) {
                    // 뺐던 값은 뒤로 입력
                    document.offer(first);
                    // i 번째에 first 보다 큰 값이 있는 것이므로 그 전 요소들은 전부 뽑아서 뒤로 입력
                    for (int j = 0; j < i; j++) {
                        document.offer(document.poll());
                    }
                    // first 보다 큰 값을 찾았으니 false 로 변경
                    isMax = false;
                    break;
                }
            }
            // 첫 요소가 최대가 아닐 경우 while 종료를 피하기 위해 continue
            if (!isMax)
                continue;

            // 최대값일 경우 queue 에서 빼고 count 증가
            count++;

            // 첫 요소가 최대 요소이고 찾으려는 순서의 문서일 경우 while 종료
            if(first[0] == M)
                break;
        }
        result.append(count).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        result = new StringBuilder();

        for (int i = 0; i < T; i++) {
            // 테스트 케이스 첫번째 줄 가져오기
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 개수
            int M = Integer.parseInt(st.nextToken()); // 순서 알고 싶은 문서 번호

            // 테스트 케이스 수 만큼 큐가 존재하므로 반복문 돌 때 마다 초기화
            document = new LinkedList<>();
            // 테스트 케이스 두번째 줄 가져오기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 초기 위치와 중요도 입력
                document.add(new int[]{j, Integer.parseInt(st.nextToken())});
            }
            // 우선순위 체크
            priorityCheck(M);
        }
        result.deleteCharAt(result.length() - 1);

        br.close();

        System.out.println(result);
    }
}