import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Tower {
        int number;
        int height;
        Tower(int number, int height) {
            this.number = number;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                // 기존 입력된 타워의 높이가 다음 타워 높이보다 작으면 스택에서 빼기
                if(stack.peek().height > height) {
                    sb.append(stack.peek().number).append(" ");
                    break ;
                }
                stack.pop();
            }
            if(stack.isEmpty())
                sb.append("0").append(" ");

            stack.push(new Tower(i, height));
        }
        System.out.println(sb);
        br.close();
    }
}
