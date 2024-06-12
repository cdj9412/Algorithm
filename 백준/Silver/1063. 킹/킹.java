import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 시간 복잡도 : O(N)
    static char[] kingLocation, stoneLocation ; // 0: 열 1: 행
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        kingLocation = st.nextToken().toCharArray(); // 킹의 위치
        stoneLocation = st.nextToken().toCharArray(); // 돌의 위치
        N = Integer.parseInt(st.nextToken()); // 움직임 횟수

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            // 킹 이동
            char[] tempKing = moveLocation(command, kingLocation);
            if (rangeCheck(tempKing)) continue; // 이동 후 범위 체크
            
            // 돌 위치와 겹치면 돌 위치 이동
            if(stoneLocation[0] == tempKing[0] && stoneLocation[1] == tempKing[1]) {
                char[] tempStone = moveLocation(command, stoneLocation);
                if (rangeCheck(tempStone)) continue; // 이동 후 범위 체크
                stoneLocation = tempStone;
            }

            kingLocation = tempKing;
        }
        System.out.println(kingLocation);
        System.out.println(stoneLocation);
    }

    // 체스판 좌표 범위 초과 확인
    public static boolean rangeCheck(char[] location) {
        return (location[0] > 'H' || location[0] < 'A' || location[1] > '8' || location[1] < '1');
    }

    // 체스판 좌표 이동
    public static char[] moveLocation(String command, char[] location) {
        char[] moveLocation = location.clone();
        switch (command) {
            case "R": moveLocation[0]++; break;
            case "L": moveLocation[0]--; break;
            case "B": moveLocation[1]--; break;
            case "T": moveLocation[1]++; break;
            case "RT":
                moveLocation[0]++; moveLocation[1]++;
                break;
            case "LT":
                moveLocation[0]--; moveLocation[1]++;
                break;
            case "RB":
                moveLocation[0]++; moveLocation[1]--;
                break;
            case "LB":
                moveLocation[0]--; moveLocation[1]--;
                break;
            default : break;
        }

        return moveLocation;
    }
}