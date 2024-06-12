import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    // 최대 길이가 50이라 O(N^2) 까지는 가능 - 이중 for 문
    // 잘라야 하니까 substring 사용
    // 자르는 인덱스는 for 문의 반복 인자를 활용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputWord = br.readLine();

        ArrayList<String> changeWords = new ArrayList<>();

        int inputLength = inputWord.length();
        for (int i = 1; i < inputLength; i++) {
            // 인덱스 겹치면 안되니 i 다음 인덱스로
            for (int j = i+1; j < inputLength; j++) {
                // 매번 초기화 해줘야 내용물 비워짐
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                StringBuilder sbResult = new StringBuilder();

                sb1.append(inputWord.substring(0,i)).reverse(); // 첫 부분 단어 뒤집기 까지
                sb2.append(inputWord.substring(i,j)).reverse(); // 중간 부분 단어
                sb3.append(inputWord.substring(j,inputLength)).reverse(); // 마지막 부분 단어

                sbResult.append(sb1).append(sb2).append(sb3);

                changeWords.add(sbResult.toString()); ;
            }
        }
        Collections.sort(changeWords);
        System.out.println(changeWords.get(0));
    }
}