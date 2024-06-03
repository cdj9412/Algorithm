import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] input;
    static boolean largeFlag = false;

    static void findSquare(int maxLine) {
        // 배열용 인덱스 변수 선언
        int maxArrayLine = maxLine - 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(j < M - maxArrayLine && i < N - maxArrayLine){
                    if(input[i][j] == input[i+maxArrayLine][j]
                        && input[i][j] == input[i][j+maxArrayLine]
                        && input[i][j] == input[i+maxArrayLine][j+maxArrayLine]) {
                        largeFlag = true;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 제한 조건
        if (N < 1 || N > 50 || M < 1 || M > 50) {
            System.out.println("잘못된 입력");
            br.close();
            return;
        }

        input = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                input[i][j] = line.charAt(j) - '0';
        }

        // 출력할 수 있는 가장 큰 정사각형 변의 길이
        int lowerValue = Math.min(N, M);
        int result = 1 ;
        for(int i = lowerValue; i >= 0; i-- ){
            findSquare(i);
            if(largeFlag) {
                result = i;
                break;
            }
        }
        System.out.println((int)Math.pow(result,2));
    }
}
