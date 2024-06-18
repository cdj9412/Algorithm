import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static class Coordinate {
        double X;
        double Y;
        public Coordinate(double X, double Y) {
            this.X = X;
            this.Y = Y;
        }
    }
    static Coordinate[] coordinates;

    static class Time {
        int target;
        double time;
        public Time(int target, double time) {
            this.target = target;
            this.time = time;
        }
    }
    static ArrayList<ArrayList<Time>> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 달리기 : 5m/s 대포 : 25m/s
        // 그냥 거리로 계산하는건 한계가 있음. 시간을 구해야함.
        // 각 좌표에서 목표 좌표와 목표 좌표까지의 거리를 구해서 시간을 담아둬야할듯
        String[] startCoordinate = br.readLine().split(" ");
        double startX = Double.parseDouble(startCoordinate[0]); // 출발 X 좌표
        double startY = Double.parseDouble(startCoordinate[1]); // 출발 Y 좌표
        Coordinate start = new Coordinate(startX, startY);

        String[] endCoordinate = br.readLine().split(" ");
        double endX = Double.parseDouble(endCoordinate[0]); // 도착 X 좌표
        double endY = Double.parseDouble(endCoordinate[1]); // 도착 Y 좌표
        Coordinate end = new Coordinate(endX, endY);

        n = Integer.parseInt(br.readLine()); // 대포 수

        // 0은 시작점 length-1은 도착점
        // 좌표 입력
        coordinates = new Coordinate[n+2];
        coordinates[0] = start;
        for(int i = 1; i < n+1; i++) {
            String[] inputCannon = br.readLine().split(" ");
            coordinates[i] = new Coordinate(Double.parseDouble(inputCannon[0]), Double.parseDouble(inputCannon[1]));
        }
        coordinates[coordinates.length-1] = end;

        // 거리 계산
        nodes = new ArrayList<>();
        for(int i = 0; i < n+2; i++)
            nodes.add(new ArrayList<>());

        // 출발 지점에서의 시간 저장 - 대포 없음
        for(int i = 1; i < n+2; i++) {
            nodes.get(0).add(new Time( i, (calculateDistance(start, coordinates[i]) / 5) ));
        }

        // 나머지 대포에서의 최단 시간 저장
        for(int i = 1; i < n+2; i++) {
            for(int j = 0; j < n+2; j++) {
                double distance = calculateDistance(coordinates[i], coordinates[j]);
                double walkTime = distance / 5;

                double cannonTime ;
                if (distance < 10)
                    cannonTime = walkTime; // 커리가 10m 보다 짧으면 대포타고 걸어가는 것보다 그냥 걸어 가는게 빠름
                else
                    cannonTime = (Math.abs(distance - 50) / 5) + 2; // 50보다 짧을 수 있어서 abs 처리

                nodes.get(i).add(new Time( j, Math.min(walkTime, cannonTime) ));
            }
        }
        dijkstra(0);
    }

    public static double calculateDistance(Coordinate c1, Coordinate c2) {
        // 두 좌표 사이의 거리 : sqrt((|x1-x2|)^2 + (|y1-y2|)^2)
        double result = 0;
        double resultX = Math.pow(Math.abs(c1.X - c2.X), 2);
        double resultY = Math.pow(Math.abs(c1.Y - c2.Y), 2);
        result = Math.sqrt(resultX + resultY);
        return result;
    }
    
    public static void dijkstra(int start) {
        // 시간 적은 순으로
        PriorityQueue<Time> pq = new PriorityQueue<>((o1,o2)-> {
            return (int)(o1.time - o2.time);
        });
        pq.offer(new Time(start, 0));

        double[] times = new double[n+2]; // 각 위치까지의 최소 시간
        Arrays.fill(times, Integer.MAX_VALUE);
        times[start] = 0;
        boolean[] visited = new boolean[n+2];

        while(!pq.isEmpty()) {
            Time current = pq.poll();

            if(visited[current.target]) continue;

            visited[current.target] = true;
            // 이러면 마지막 값이 최단거리가 나올건데
            for(Time next : nodes.get(current.target)) {
                if(times[next.target] > times[current.target] + next.time) {
                    times[next.target] = times[current.target] + next.time;
                    pq.offer(new Time(next.target, times[next.target]));
                }
            }
        }
        System.out.println(times[n+1]);
    }
}