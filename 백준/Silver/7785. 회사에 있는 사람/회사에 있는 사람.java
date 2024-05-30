import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 제한 조건 처리
        if(n < 2 || n > 1000000) {
            System.out.println("잘못된 입력");
            return;
        }

        // 중복 이름 체크를 위해 HashMap
        Map<String, String> enterRecord = new HashMap<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String record = st.nextToken();

            // 출입기록은 순서대로 주어지므로,
            // 출근 로그 확인 시 맵에 넣고 퇴근 로그 확인 시 지워 버리기
            if (record.equals("enter"))
                enterRecord.put(name, record);
            else
                enterRecord.remove(name);
        }

        // 회사에 남은 인원들의 이름에 대한 정렬을 사용하려면 List 를 사용해야 함
        List<String> person = new ArrayList<>(enterRecord.keySet());

        // 역순 정렬
        person.sort(Collections.reverseOrder());

        for(String name : person)
            System.out.println(name);

        br.close();
    }
}