import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 단어의 알파벳 별로 갯수 저장하기 위한 HashMap 선언
        Map<Character, Integer> alphabet = new HashMap<>() ;

        // 대소문자 상관없이 같은 알파벳만 확인하고 마지막에 대문자로 출력해서 받는 동시에 대문자로 변경
        String inputData = br.readLine().toUpperCase();

        // 제한 조건
        if (inputData.length() > 1000000){
            System.out.println("잘못된 입력");
            return ;
        }

        for(char inputChar : inputData.toCharArray()) {
            if(alphabet.containsKey(inputChar)) {
                // 이미 있던 알파벳이면 갯수 증가
                int existCount = alphabet.get(inputChar);
                alphabet.put(inputChar, (existCount + 1));
            }
            else {
                // 없던 알파벳이면 1로 Map 에 추가
                alphabet.put(inputChar, 1);
            }
        }

        // 최대를 찾기 위해 사용하는 변수 초기화
        char maxChar = '?' ;
        int maxCount = 0 ;
        
        for(Map.Entry<Character, Integer> entry : alphabet.entrySet()) {
            char currentAlphabet = entry.getKey();
            int count = entry.getValue();

            if(count > maxCount) {
                // 최대값 보다 큰 개수를 찾으면 알파벳과 카운트 재입력
                maxChar = currentAlphabet ;
                maxCount = count ;

            }
            else if(count == maxCount) {
                // 최대 값이 같을 경우 maxChar ? 로 변경
                maxChar = '?';
            }
        }
        System.out.println(maxChar);
    }
}
