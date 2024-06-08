import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 최종 시간 복잡도 : O(logN)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = getPercent(X,Y);
        // 승률이 99나 100이면 소수점 버리기 때문에 승률이 변하지 않음.
        if (Z == 99 || Z == 100) {
            System.out.println(-1);
            return;
        }
        System.out.println(binarySearch(X,Y,Z)); // O(logN)
    }

    public static long binarySearch(long X, long Y, long target) {
        long start = 0;
        long end = X;
        while (start < end) { //O(logN)
            long mid = (start + end) / 2;
            if(getPercent((X + mid),(Y + mid)) > target)
                end = mid;
            else
                start = mid + 1;
        }
        return end;
    }

    public static long getPercent(long X, long Y){
        return (long)((Y*100) / X) ;
    }
}
