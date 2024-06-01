import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        StringBuilder N = new StringBuilder(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 제한 조건
        if(!N.toString().equals(N.toString().toUpperCase()) || B < 2 || B > 36) {
            bw.write("잘못된 입력\n");
            bw.flush();
            bw.close();
            return ;
        }
        // 입력된 N 을 뒤집어서 낮은 차수부터 계산
        N.reverse();

        long result = 0;
        int degree = 0 ;
        long charToInt = 0 ;
        for(int i = 0; i < N.length(); i++) {
            // 입력된 N 을 한자리씩 integer 로 변환
            charToInt = (int) N.charAt(i) ;
            if(charToInt >= 48 && charToInt <= 57) {
                // 입력된 데이터가 숫자 였을 경우 48(0)~57(9)
                charToInt -= 48;
            }
            else {
                // 입력된 데이터가 알파벳 일 경우 65(A)~90(Z)
                charToInt -= 55;
            }

            if (charToInt == 0) {
                degree++;
                continue;
            }
            // 변환된 int 값과 B 의 degree 제곱을 곱한 값을 결과에 적산
            result += charToInt * (long) Math.pow(B,degree);
            degree++;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
