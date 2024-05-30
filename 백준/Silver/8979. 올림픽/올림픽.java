import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 줄 국가의 수, 등수 확인 국가 번호 지정
        int N = Integer.parseInt(st.nextToken());
        int targetK = Integer.parseInt(st.nextToken());

        // 0 : 국가코드 / 1 : 금메달 개수 / 2 : 은메달 개수 / 3 : 동메달 개수
        int[][] contries = new int[N][4];

        // 알고자하는 국가의 메달 개수 저장
        int targetG = 0;
        int targetS = 0;
        int targetB = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            contries[i][0] = Integer.parseInt(st.nextToken());
            contries[i][1] = Integer.parseInt(st.nextToken());
            contries[i][2] = Integer.parseInt(st.nextToken());
            contries[i][3] = Integer.parseInt(st.nextToken());

            if (targetK == contries[i][0]) {
                targetG = contries[i][1];
                targetS = contries[i][2];
                targetB = contries[i][3];
            }
        }

        // 국가 순위 초기화
        int rank = 1;
        for (int i = 0; i < N; i++) {
            // 타겟 국가번호는 패스
            if (contries[i][0] == targetK)
                continue;

            // 금메달이 적으면 rank 증가
            if (targetG < contries[i][1])
                rank++ ;
            else if (targetG == contries[i][1]) {
                // 금메달이 같을 경우
                // 은메달이 적으면 rank 증가
                if (targetS < contries[i][2])
                    rank++;
                else if (targetS == contries[i][2]) {
                    // 은메달이 같을 경우
                    // 동메달이 적으면 rank 증가
                    if (targetB < contries[i][3])
                        rank++;
                }
            }
        }
        System.out.println(rank);
    }
}
