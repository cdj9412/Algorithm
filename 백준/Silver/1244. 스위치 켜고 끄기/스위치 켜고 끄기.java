import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] switchStatus;

    static void changeSwitchStatus(int index) {
        if (switchStatus[index] == 1)
            switchStatus[index] = 0;
        else
            switchStatus[index] = 1;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 스위치 수
        int N = Integer.parseInt(br.readLine());
        // 제한 조건
        if (N < 1 || N > 100) {
            System.out.println("잘못된 입력");
            br.close(); return;
        }

        // 스위치 상태
        switchStatus = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            switchStatus[i] = Integer.parseInt(st.nextToken());

        //학생 수
        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int G = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // 성별 구분
            if(G == 1){
                // 남자 일때
                for(int j = 0; j < N; j++) {
                    // 받은 숫자의 배수 위치에 있는 스위치 상태 바꾸기
                    if((j+1) % R == 0)
                        changeSwitchStatus(j);
                }
            }
            else{
                // 여자일 때 뽑은 수를 중심으로 좌우 대칭이면 상태 바꾸기
                // 지금 0번 부터 들어가 있고 받은 번호는 1번부터임 -> 배열에서는 R-1이 해당 위치임 기억하기
                // 일단 해당 스위치 변환
                changeSwitchStatus(R-1);

                // 양쪽 체크라서 중앙기준으로 해도 전체 스위치 개수의 반만 확인해도 됨.
                for(int j = 1 ; j < N/2; j++){
                    // 해당 스위치에서 j를 빼거나 더했을 때 총 개수나 0을 넘어가면 종료
                    if((R-1)-j < 0 || (R-1)+j >= N)
                        break;
                    if(switchStatus[(R-1)-j] == switchStatus[(R-1)+j]) {
                        // 앞
                        changeSwitchStatus(R-1-j);
                        // 뒤
                        changeSwitchStatus(R-1+j);
                    }
                    else
                        break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            sb.append(switchStatus[i]).append(" ");
            if(((i+1) % 20) == 0) {
                sb.deleteCharAt(sb.length()-1);
                sb.append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}