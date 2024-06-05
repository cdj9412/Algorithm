import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
         * 여는 괄호가 들어올 때 stack 에 push 해서 쌓고
         * 닫는 괄호가 들어올 때 stack 에서 pop 으로 뽑아내서
         * 1. 정상적으로 stack 이 빈 상태가 되면 YES
         * 2. stack 에 요소가 남아있으면 NO
         * 3. stack 에 요소가 없는데 pop 해야 하는 상황이 와도 NO
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Stack<Character> stack ;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            
            boolean flag = true ;
            stack = new Stack<>();

            for (char bracket : input.toCharArray()) {
                if (bracket == '(') {
                    stack.push(bracket);
                }
                else {
                    // pop 하기 전에 이미 비어있는 상태이면 flag false 처리
                    if (stack.isEmpty()) {
                        flag = false ;
                        break;
                    }
                    stack.pop();
                }
            } //foreach
            
            // 이미 비어있어도 조건에 만족하지 못해 false 인 경우가 있어서 한번 더 조건 처리
            if (flag) {
                if (stack.isEmpty()) 
                    sb.append("YES\n"); // 상단의 1번 조건
                else 
                    sb.append("NO\n"); // 상단의 2번 조건
            }
            else 
                sb.append("NO\n"); // 상단의 3번 조건
            
        } // for T
        System.out.println(sb);
    }
}
