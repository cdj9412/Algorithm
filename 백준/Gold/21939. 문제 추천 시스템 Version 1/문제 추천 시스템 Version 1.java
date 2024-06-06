import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Question {
        int P; // 문제 번호
        int L; // 문제 난이도

        public Question(int P, int L) {
            this.P = P;
            this.L = L;
        }
    }

    static HashMap<Integer, Integer> questionMap;
    static TreeSet<Question> treeSet;

    static void recommend(int x) {
        // x 가 1인 경우 가장 어려운 문제 출력, 여러 개라면 문제 번호 큰 것 출력
        // x 가 -1인 경우 가장 쉬운 문제 출력, 여러 개라면 문제 번호 작은 것 출력
        if (x == 1)
            System.out.println(treeSet.last().P);
        else
            System.out.println(treeSet.first().P);
    }

    static void add(int P, int L) {
        // 추천 문제 리스트에 난이도 L 인 문제번호 P 를 추가
        // 추천 문제 리스트에 없는 문제 번호만 P 로 주어짐
        // 추천 문제 리스트에 있던 문제 번호가 다른 난이도로 다시 들어올 수는 있음.
        // 지울 때를 생각해서 문제번호를 키로 입력
        questionMap.put(P, L);
        treeSet.add(new Question(P,L));
    }

    static void solved(int P) {
        // 추천 문제 리스트에서 문제 번호 P 를 제거
        // 추천 문제 리스트에 없는 문제 번호만 P 로 주어짐
        treeSet.remove(new Question(P,questionMap.get(P)));
        questionMap.remove(P);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 문제 수

        questionMap = new HashMap<>(); // 문제, 난이도 관리용
        // 최대, 최소 난이도 출력용
        treeSet = new TreeSet<>((obj1, obj2) -> {
            if (obj1.L == obj2.L) // 문제번호 같으면
                return obj1.P - obj2.P; // 문제번호 작은 순

            return obj1.L - obj2.L; // 기본 - 난이도 오름차순
        });

        
        StringTokenizer st ;
        // 문제 입력
        // 시간복잡도 O(n)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); // 문제 번호
            int L = Integer.parseInt(st.nextToken()); // 문제 난이도
            add(P, L);
        }

        int M = Integer.parseInt(br.readLine()); // 명령문 개수
        for (int i = 0; i < M; i++) {  //O(n)
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                recommend(x); // O(n)
            }
            else if (command.equals("solved")) {
                int problemNumber = Integer.parseInt(st.nextToken());
                solved(problemNumber);
            }
            else {
                int problemNumber = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                add(problemNumber, level);
            }
        }
    }
}