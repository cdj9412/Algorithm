import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t, n, d, c;
    static class Dependency {
        int a;
        int s;
        public Dependency(int a, int s) {
            this.a = a;
            this.s = s;
        }
    }
    static ArrayList<ArrayList<Dependency>> dependencies;
    static int[] infectTime; // visited 역할 동시 수행
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < t; i++) {
            String[] testCase = br.readLine().split(" ");
            n = Integer.parseInt(testCase[0]); // 컴퓨터 개수
            d = Integer.parseInt(testCase[1]); // 의존성 개수
            c = Integer.parseInt(testCase[2]); // 해킹당한 최초의 컴퓨터

            // 의존성 리스트 초기화
            dependencies = new ArrayList<>();
            for (int j = 1; j <= n+1; j++)
                dependencies.add(new ArrayList<>());

            for (int j = 0; j < d; j++) {
                String[] dependencyInfo = br.readLine().split(" ");
                int a = Integer.parseInt(dependencyInfo[0]); // PC a
                int b = Integer.parseInt(dependencyInfo[1]); // PC b
                int s = Integer.parseInt(dependencyInfo[2]); // 감염 시간
                dependencies.get(b).add(new Dependency(a, s));
            }
            BFS() ;
            setResult() ;
        }
        System.out.println(sb);
        br.close();
    }

    // 출력데이터 세팅용 메서드
    public static void setResult() {
        int timeCount = infectTime.length;
        int infectCount = 0;
        int lastInfectTime = 0;
        for (int i = 0; i < timeCount; i++) {
            if (infectTime[i] != Integer.MAX_VALUE) {
                infectCount++;
                lastInfectTime = Math.max(lastInfectTime, infectTime[i]);
            }
        }
        sb.append(infectCount).append(" ").append(lastInfectTime).append("\n");
    }

    // 최단거리 BFS 사용
    public static void BFS() {
        Queue<Dependency> queue = new ArrayDeque<>();
        queue.add(new Dependency(c, 0));

        infectTime = new int[n + 1];
        Arrays.fill(infectTime, Integer.MAX_VALUE);
        infectTime[c] = 0; // 최초 감염 PC 는 0으로 초기화

        while (!queue.isEmpty()) {
            Dependency currentDependency = queue.poll();
            int currentPC = currentDependency.a;
            int second = currentDependency.s;
            int dependencyCount = dependencies.get(currentPC).size();

            for (int i = 0; i < dependencyCount; i++) {
                Dependency nextDependency = dependencies.get(currentPC).get(i);

                // 기존에 있던 감염시간이 현재 pc 에서 다음 pc 까지의 감염시간 합보다 더 느리면 교체
                if (infectTime[nextDependency.a] > second + nextDependency.s) {
                    infectTime[nextDependency.a] = second + nextDependency.s;
                    queue.add(new Dependency(nextDependency.a, second + nextDependency.s));
                }
            }
        }
    }
}