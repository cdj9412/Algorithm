import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 제한 조건
        if(N < 1 || N > 100) {
            bw.write("잘못된 입력\n");
            bw.flush(); bw.close(); br.close();
            return ;
        }

        Set<String> set = new HashSet<>();
        char before  = '0';
        char after = '0';
        boolean beforeFlag = false ;
        boolean afterFlag = false ;

        String word;
        for(int i = 0; i < N; i++) {
            word = br.readLine();
            if(!word.equals("?")) {
                // ?가 아니면 순회를 돌면서 단어 저장
                set.add(word);
                // beforeFlag 가 true 가 되면 after 문자 저장
                if(beforeFlag && !afterFlag) {
                    after = word.charAt(0);
                    afterFlag = true ;
                }
            }
            else
                beforeFlag = true ;

            // beforeFlag 가 true 가 될 때 까지(?가 나오기 전 까지) 단어의 마지막 문자를 저장
            if(!beforeFlag)
                before = word.charAt(word.length()-1);
        }

        // 저장할 결과
        String result = "";

        int M = Integer.parseInt(br.readLine());
        // 제한 조건
        if(M < 1 || M > 100) {
            bw.write("잘못된 입력\n");
            bw.flush(); bw.close(); br.close();
            return ;
        }

        String candidate;
        for(int i = 0; i < M; i++) {
            candidate = br.readLine();
            // 후보 단어의 첫글자가 같거나 before 가 없고
            // 후보 단어의 마지막 글자가 같거나 after 가 없고
            // 기존 단어에 없어야 함.
            if((candidate.charAt(0) == before || before == '0')
                    && (candidate.charAt(candidate.length()-1) == after || after == '0')
                    && !set.contains(candidate))
                result = candidate;
        }

        bw.write(result+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}