import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder result ;

    public static void findCombination(HashMap<String,String> dress) {
        HashMap<String,Integer> typeCount = new HashMap<>();
        // foreach 문을 통해 의상 종류 별 카운트 입력
        dress.forEach((key,value)->{
            typeCount.put(value, typeCount.getOrDefault(value,0) + 1);
        });

        int combinationCount = 1; //곱 연산을 위해 1로 초기화
        // 각 의상 종류 별 조합 계산해서 입력
        for (Map.Entry<String,Integer> type : typeCount.entrySet()) {
            // 한 종류의 의상만 입는 상태를 체크하기 위해 각 의상 종류에 알몸 상태 추가 계산
            combinationCount *= (type.getValue()+1);
        }
        // 알몸인 경우를 제외
        combinationCount -= 1;
        result.append(combinationCount).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        result = new StringBuilder();

        // 의상 종류를 value 로 쓰면 HashMap 사용해도 될지도?
        HashMap<String, String> dress;
        for (int i = 0; i < T; i++) {
            int dressCount = Integer.parseInt(br.readLine()); // 의상 수
            dress = new HashMap<>(); // 테스트 케이스 별 초기화

            for (int j = 0; j < dressCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String dressName = st.nextToken();
                String dressType = st.nextToken();
                dress.put(dressName, dressType);
            }
            // 여기를 메서드화 조합 찾기
            findCombination(dress);
        }
        System.out.println(result);
        br.close();
    }
}