import java.io.*;

public class Main {
    static final int maxLineLength = 5;
    static final int maxWordLength = 15;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] inputArray = new String[maxLineLength][maxWordLength];

        // 입력된 데이터 한글자 단위로 저장
        for (int i = 0; i < maxLineLength; i++)
            inputArray[i] = br.readLine().split("");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < maxWordLength; i++) {
            for(int j = 0; j < maxLineLength; j++) {
                // j 열에 입력된 단어 길이보다 i 가 크면 넘어가기
                if(i < inputArray[j].length)
                    sb.append(inputArray[j][i]);
            }
        }
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}