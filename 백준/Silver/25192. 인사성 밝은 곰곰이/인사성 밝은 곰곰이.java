import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 제한 조건
        if (N < 1 || N > 100000) {
            System.out.println("잘못된 입력");
            return ;
        }

        // 이용자 별 이모티콘 사용내역을 확인 할 HashSet
        Set<String> chatSet = new HashSet<>();

        String name;
        int emojiCnt = 0;

        for (int i = 0; i < N; i++) {
            name = br.readLine();

            // 제한 조건
            if(i == 0) {
                if(!name.equals("ENTER")) {
                    System.out.println("잘못된 입력");
                    return ;
                }
            }

            // 제한 조건
            if (name.isEmpty() || name.length() > 20) {
                System.out.println("잘못된 입력");
                return ;
            }

            if (name.equals("ENTER")) {
                // 전체 이용자의 이모티콘 사용 내역 초기화
                chatSet.clear();
            }
            else {
                // 기존에 이모티콘 사용내역이 없던 이용자라면
                if (!chatSet.contains(name)) {
                    // 이모티콘 사용 후 Set 에 추가
                    emojiCnt++;
                    chatSet.add(name);
                }
            }
        }
        System.out.println(emojiCnt);
    }
}