import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    // 최종 시간 복잡도 : O(NlogN)
    static class TimeTable {
        int startTime;
        int endTime;
        public TimeTable(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    static PriorityQueue<TimeTable> timeTables;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 수
        // 일찍 끝나는 회의를 우선 정렬, 시작 시간이 같아도 일찍 끝나는 회의 먼저
        timeTables = new PriorityQueue<>((o1, o2)-> {
            if (o1.endTime == o2.endTime)
                return o1.startTime - o2.startTime;
            return o1.endTime - o2.endTime;
        });

        for (int i = 0; i < N; i++) { // O(N)
            String[] time = br.readLine().split(" ");
            int startTime = Integer.parseInt(time[0]);
            int endTime = Integer.parseInt(time[1]);
            timeTables.offer(new TimeTable(startTime, endTime)); // O(logN)
        }

        System.out.println(findMax());
    }

    public static int findMax() {
        int meetCount = 0;
        int lastEndTime = 0;
        while (!timeTables.isEmpty()) {
            TimeTable current = timeTables.poll();

            if (current.startTime >= lastEndTime) {
                lastEndTime = current.endTime;
                meetCount++;
            }
        }
        return meetCount;
    }
}