import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 총 시간 복잡도 : O(N + N*logN + N^2)
    // 빅오 표기법에서 가장 큰 항만 고려 : N + N*logN + N^2  = N^2
    // 최종 시간 복잡도 : O(N^2)
    static StringBuilder sb;
    static int[] inputPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 점의 개수
        int M = Integer.parseInt(st.nextToken()); // 선분 개수

        inputPoint = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) // O(N)
            inputPoint[i] = Integer.parseInt(st.nextToken());

        // 정렬
        Arrays.sort(inputPoint); // O(N*logN)

        sb = new StringBuilder();
        for(int i = 0; i < M ; i++) { // O(N)
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            checkPoint(start, end); // O(N)
        }

        System.out.println(sb);
    }

    public static void checkPoint(int start, int end) {
        // 한번에 하면 O(N) 이라서 타임아웃이 나옴.
        // 대신에 이분탐색으로 상한 좌표, 하한 좌표를 따로 구하면 2logN -> logN 이니까 타임아웃은 안날 거임.
        int returnValue = 0;

        int lowerCoordination = checkLower(start);
        int upperCoordination = checkUpper(end);

        // 최소 좌표가 더 크면 해당하는 점이 없는 것
        if (lowerCoordination <= upperCoordination)
            returnValue = upperCoordination - lowerCoordination+1;

        sb.append(returnValue).append("\n");
    }

    public static int checkLower(int start) {
        int left = 0, right = inputPoint.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (start > inputPoint[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public static int checkUpper(int end) {
        int left = 0, right = inputPoint.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (end < inputPoint[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }
}