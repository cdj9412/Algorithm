import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 제한 조건
        if(N < 1|| M < 1 || N > 500000 | M > 500000) {
            System.out.println("잘못된 입력");
            return;
        }


        // 중복 체크를 위한 Map
        Map<String, Boolean> duplicationCheck = new HashMap<>();
        String name;
        int duplicationCnt = 0;

        for (int i = 0; i < (N+M); i++) {
            name = br.readLine();
            if(!name.equals(name.toLowerCase()) || name.isEmpty() || name.length() > 20) {
                System.out.println("잘못된 입력");
                return;
            }

            if(duplicationCheck.containsKey(name)) {
                duplicationCnt++;
                duplicationCheck.put(name, true);
            }
            else
                duplicationCheck.put(name, false);
        }


        // 정렬을 위해 담을 List 생성
        List<String> duplicationList = new ArrayList<>();


        // 듣도 보도 못한 사람 List 에 추가
        for(String duplicationName : duplicationCheck.keySet()){
            if(duplicationCheck.get(duplicationName))
                duplicationList.add(duplicationName);
        }

        // 사전순으로 정렬
        Collections.sort(duplicationList);

        System.out.println(duplicationCnt);
        for(String duplicationName : duplicationList)
            System.out.println(duplicationName);
    }
}
