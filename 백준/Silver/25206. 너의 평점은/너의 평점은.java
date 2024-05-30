import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 입력 과목 수 고정 값 선언
    public final static int SUBJECT_COUNT = 20;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전공 평점 계산을 위한 변수 선언
        double mainPoint = 0.0;
        double gradeSum = 0.0;

        // 전공평점 계산
        for (int i = 0; i < SUBJECT_COUNT; i++) {
            String[] gradeCard = br.readLine().split(" ");
            // 학점
            double grade = Double.parseDouble(gradeCard[1]);

            // P 입력 시 작업 넘기기 위한 Flag
            boolean pFlag = false ;

            // 등급 과목평점으로 전환
            String subjectClass = gradeCard[2];
            double subjectPoint = 0.0;
            switch (subjectClass) {
                case "A+": subjectPoint = 4.5; break;
                case "A0": subjectPoint = 4.0; break;
                case "B+": subjectPoint = 3.5; break;
                case "B0": subjectPoint = 3.0; break;
                case "C+": subjectPoint = 2.5; break;
                case "C0": subjectPoint = 2.0; break;
                case "D+": subjectPoint = 1.5; break;
                case "D0": subjectPoint = 1.0; break;
                case "F":  subjectPoint = 0.0; break;
                case "P":  pFlag = true; break;
            }

            if (pFlag)
                continue;

            // P 등급이 아닌 과목의 학점 합산
            gradeSum += grade ;
            // 전공 평점 계산(학점 * 과목 평점)
            mainPoint += (grade * subjectPoint);
        }
        System.out.println(mainPoint/ gradeSum);
    }
}
