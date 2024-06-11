import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] dataStructures = br.readLine().split(" "); // 자료구조 저장

        /*
         * 4
         * 0 1 1 0  <<< 큐 스택 스택 큐
         * 1 2 3 4  <<< 1  2   3   4
         * 3
         * 2 4 7
         * 출력
         * 4 1 2
         * -> 스택은 어차피 들어온 데이터를 밀어내고 큐 데이터만 뒤에서 부터 출력되고 이후로 입력된 데이터들이 출력됨
         * 따라서 스택데이터는 애초에 입력안하고 queue 만 동작하도록 하면 됨.
         */

        ArrayDeque<String> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String element = st.nextToken();
            if (dataStructures[i].equals("0"))
                deque.offerFirst(element); // 나중에 입력된 데이터가 앞으로 오도록
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            String inputData = st.nextToken();
            deque.offer(inputData);
            sb.append(deque.poll()).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}