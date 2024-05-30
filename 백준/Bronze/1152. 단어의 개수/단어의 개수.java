import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // split 으로 잘려진 단어를 담을 ArrayList
        // ArrayList 를 사용한 이유
        // 입력이 어떤 형식으로 들어올 지 모르니 Array 보다 가변적인 공간을 가진 ArrayList 가 더 적합하다고 판단함.
        ArrayList<String> inputWords = new ArrayList<>();

        for(String inputData : br.readLine().split(" ")) {
            // 앞 뒤 공백 있을 시 제외
            if(!inputData.isEmpty())
                inputWords.add(inputData);
        }

        System.out.println(inputWords.size());

    }
}
