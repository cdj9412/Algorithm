import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 풍선 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 풍선 데이터
        LinkedList<Integer> balloon = new LinkedList<>();
        //int[] balloons = new int[N];
        // 인덱스 비교용
        Deque<Integer> list = new ArrayDeque<>();
        //int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            balloon.add(Integer.parseInt(st.nextToken()));
            list.addLast(i);
        }
        // balloon 리스트가 빌때까지
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            // 뽑아내는 건 list, 종이 데이터를 가져오는 건 balloon
            int targetIndex = list.removeFirst();
            int paperValue = balloon.get(targetIndex);

            if(!list.isEmpty()) {
                if (paperValue > 0) {
                    // 오른쪽(+)으로 갈 땐 paperValue -1
                    for (int i = 0; i < (paperValue-1); i++)
                        list.addLast(list.removeFirst());
                }
                else {
                    // 왼쪽으로(-) 갈 땐  |paperValue| 만큼 이동
                    int loopValue = Math.abs(paperValue);
                    for (int i = 0; i < loopValue; i++)
                        list.addFirst(list.removeLast());
                }
            }
            sb.append(targetIndex+1).append(" ");
        }
        System.out.println(sb);
    }
}
