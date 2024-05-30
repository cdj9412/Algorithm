import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        Map<String, Integer> result = new HashMap<>() ;

        // 펼쳐질 카드 개수 입력
        int N = Integer.parseInt(br.readLine()) ;
        // 제한 조건 체크
        if(N < 1 || N> 100000) {
            System.out.println("잘못된 입력");
            return ;
        }

        String S;
        int X;
        for(int i = 0 ; i < N ; i++) {
            // split 보다 빠르게 공백문자를 기준으로 데이터를 분리 할 수 있음.
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            S = stringTokenizer.nextToken().toUpperCase();
            X = Integer.parseInt(stringTokenizer.nextToken());

            // 제한조건 확인
            if (X < 1 || X > 5) {
                System.out.println("잘못된 입력");
                return;
            }

            // 해당 과일이 있는지 확인
            if(!result.containsKey(S)){
                // 없으면 입력
                result.put(S, X);
            } else {
                // 있으면 기존 값에 더해서 입력
                int existVal = result.get(S);
                result.put(S, existVal + X) ;
            }
        }

        // Map 의 객체 중에 정확하게 5라는 값을 가진 것이 있으면 YES 아니면 NO
        if( result.containsValue(5))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}