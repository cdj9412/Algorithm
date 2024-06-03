import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int ArrayLength = 9;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;

        int maxRow = 0;
        int maxCol = 0;
        int tempValue = 0;
        int maxValue = 0;

        for(int row = 1; row <= ArrayLength; row++) {
            // 입력된 행의 원소 값들을 토큰화
            st = new StringTokenizer(br.readLine());
            for(int col = 1; col <= ArrayLength; col++) {
                // 현재값 저장
                // 최대값이 두 개 이상인 경우 한 곳만 출력해도 되므로 같아도 덮어씌우도록 처리
                tempValue = Integer.parseInt(st.nextToken());
                if(tempValue >= maxValue) {
                    // 현재값과 최대값 비교 후 해당 행 열 번호와 값 교체
                    maxRow = row;
                    maxCol = col;
                    maxValue = tempValue;
                }
            }
        }

        bw.write(maxValue + "\n");
        bw.write(maxRow +" "+ maxCol + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}