import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 스카이라인 고도 지점 개수

        // 스택으로 구현
        // 전부 다 넣고 구현하면 낮아졌다가 높아지는 구간과 0에서 높아지는 구간 구현이 안됨...
        // 넣으면서 이전에 입력되었던 값보다 낮은 값이 확인되면 stack 에 넣기만 하기
        ArrayDeque<Coordinate> stack = new ArrayDeque<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                // 마지막에 입력되었던 높이보다 높거나 같으면 break
                if (stack.peek().y <= y)
                    break;

                Coordinate current = stack.pop(); // 스택에서 가장 마지막에 들어온 건물 꺼내기

                // 현재 건물 높이가 0인 경우 카운트하지 않음
                if (current.y == 0)
                    continue;

                // 스택이 비어있지 않고 스택의 다음 건물이 현재 건물과 같은 높이인 경우 카운트하지 않음
                if (!stack.isEmpty() && stack.peek().y == current.y)
                    continue;

                count++; // 건물 개수 증가
            }

            // 먼저 넣으면 높이가 낮은 건물이 중복되게 카운팅 됨.
            stack.push(new Coordinate(x, y));
        }

        // 위 처럼 진행하면 스택에 남은 값이 존재함.
        // 남은 스택을 전부 비울때까지 진행
        while (!stack.isEmpty()) {
            Coordinate current = stack.pop(); // 스택에서 가장 마지막에 들어온 건물 꺼내기

            // 현재 건물 높이가 0인 경우 카운트하지 않음
            if (current.y == 0)
                continue;

            // 스택이 비어있지 않고 스택의 다음 건물이 현재 건물과 같은 높이인 경우 카운트하지 않음
            if (!stack.isEmpty() && stack.peek().y == current.y)
                continue;

            count++; // 건물 개수 증가
        }

        System.out.println(count);
        br.close();
    }
}
