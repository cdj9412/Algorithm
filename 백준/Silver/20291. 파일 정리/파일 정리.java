import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String,Integer> extensionMap = new HashMap<>();
        List<String> extensionList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String extension = st.nextToken();

            // Map 에 해당 확장자가 없으면 List 에 추가 중복일 경우 패스
            if(!extensionMap.containsKey(extension))
                extensionList.add(extension);

            // 해당 확장자가 처음이면 0으로 입력, 이외에는 기존 값에 +1
            extensionMap.put(extension, extensionMap.getOrDefault(extension, 0) + 1) ;
        }

        // 확장자 사전순으로 정렬
        Collections.sort(extensionList);

        StringBuilder sb = new StringBuilder();
        // 리스트의 키 값을 활용해 기존 맵의 파일 개수 가져와 출력
        for(String extension : extensionList)
            sb.append(extension).append(" ").append(extensionMap.get(extension)).append("\n");
        System.out.println(sb);
    }
}