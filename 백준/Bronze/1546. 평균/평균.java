import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 과목 수 입력
        int N = Integer.parseInt(br.readLine());
        String[] subjects = br.readLine().split(" ");

        // 입력된 과목 수와 점수의 수가 다르면 return
        if (N !=subjects.length) {
            System.out.println("잘못된 입력");
            return;
        }

        // 최고 점수 구하고 int 배열에 집어넣기
        int maxScore = 0;
        List<Integer> subjectScoresList = new ArrayList<>();

        for( String subject : subjects ) {
            int score = Integer.parseInt(subject);
            subjectScoresList.add(score);

            if (score > maxScore) {
                maxScore = score;
            }
        }
        
        // 점수 조작 및 조작된 점수의 평균 산출
        // 조작된 점수들의 합
        double sumScore = 0;
        for( int score: subjectScoresList ) {
            sumScore += (double)score/(double)maxScore*100;
        }

        System.out.println(sumScore/N);
    }
}
