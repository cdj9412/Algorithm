import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        br.close();
        int[] alphabet = new int[26];

        // 팰린드롬이 되려면 같은 문자만 쌍으로 존재하거나
        // 하나 일때는 만족
        // 홀수 개일 경우 문자 하나를 제외하고 문자가 쌍으로 있어야 함.
        // 그러면 대문자 알파벳을 카운팅 할 int 배열을 만들어서 개수를 입력하고
        // 일단 개수가 홀수인게 1개 이상인지 체크
        int nameLength = name.length();
        for (int i = 0; i < nameLength; i++) {
            int alphabetIndex = name.charAt(i) - 'A';
            alphabet[alphabetIndex]++;
        }
        int alphabetLength = alphabet.length;

        // 홀수 개일 경우 문자 하나를 제외하고 문자가 쌍으로 있어야 함.
        // 그러면 대문자 알파벳을 카운팅 할 int 배열을 만들어서 개수를 입력하고
        // 일단 개수가 홀수인게 1개 이상인지 체크
        int oddCheck = 0;
        char centerChar = '0';
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < alphabetLength; i++) {
            // 홀수개 처리
            if (alphabet[i] % 2 != 0 && alphabet[i] != 0) {
                if (oddCheck == 0) {
                    oddCheck++;
                    centerChar = (char) ('A' + i);
                }
                else{
                    oddCheck++;
                    result.append("I'm Sorry Hansoo");
                    break;
                }
            }
            // 짝수개처리
            for (int j = 0; j < alphabet[i]/2; j++) {
                // 앞에서부터 조회하는 것 이기 때문에 사전순으로
                // 앞뒤에 순서대로 쌓임
                front.append((char)(i+'A'));
                back.insert(0, (char)(i+'A'));
            }
        }

        // oddCheck 가 2 이상이면 불가능함.
        if(oddCheck < 2){
            if(centerChar == '0') // 문자 개수 짝수 일 때
                result.append(front).append(back);
            else // 문자 개수 홀수 일 때
                result.append(front).append(centerChar).append(back);
        }
        System.out.println(result);
    }
}