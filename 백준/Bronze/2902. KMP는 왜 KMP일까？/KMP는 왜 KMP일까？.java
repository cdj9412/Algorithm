import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String longFormName = br.readLine();
        br.close();

        // 제한 조건
        if (longFormName.isEmpty() || longFormName.length() > 100) {
            bw.write("잘못된 입력\n");
            return ;
        }

        StringBuilder shortFormName = new StringBuilder();
        for(String lastName : longFormName.split("-"))
            shortFormName.append(lastName.charAt(0));

        // BufferedWriter 는 자동개행 기능이 없어 자동개행 처리 해줘야 함.
        bw.write(shortFormName.toString() + "\n");

        // BufferedWriter 닫기
        bw.flush(); // 남아있던 데이터 모두 출력
        bw.close();
    }
}