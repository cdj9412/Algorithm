import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
     * 파라메트릭 서치
     * start 에는 최소값 : 1
     * end 에는 N 이 target 값이 되니까 : 2*N -1
     * 징검 다리의 최대 값은 등차 수열 : N*(N+1)/2
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());
            long min = 1; long max = (long)Math.sqrt(2*N)+1;
            long answer = lowerBound(min, max, N);
            System.out.println(answer);
        }

    }

    static long lowerBound(long start, long end, long target){
        long mid;
        while(start < end) {
            mid = (start + end) / 2;
            long jumpMax = mid*(mid+1)/2 ;
            if(jumpMax >= target){
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (start*(start+1)/2 > target)
            return start-1;
        else
            return start;
    }
}