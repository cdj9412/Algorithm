import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 중복 비허용 - 조합
    // 시간 복잡도 : O(2^N) - 조합 사용
    static int N, S;
    static int result = 0;
    static int[] numberList ;
    static boolean[] visited ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 입력 정수의 개수
        S = Integer.parseInt(st.nextToken()); // 목표 값

        numberList = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            numberList[i] = Integer.parseInt(st.nextToken());

        for(int i= 1; i <= N ; i++)
            combination(0,i);

        System.out.println(result);
    }

    static int sum = 0;
    public static void combination(int start, int combinationLength) {
        int arraySize = numberList.length;

        if(combinationLength == 0) {
            for(int i = 0 ; i < arraySize ; i++) {
                if(visited[i])
                    sum += numberList[i];
            }
            if (sum == S)
                result++;
        }

        for(int i = start ; i < N ; i++) {
            visited[i] = true;
            combination(i+1, combinationLength-1);
            sum = 0; // 여기서 초기화
            visited[i] = false;
        }
    }
}
