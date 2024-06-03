import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static String[][] chessBoard;

    // 8*8이니까 최대 경우의 수는 전체를 다른 색으로 바꾸는 경우인 64
    // 그리고 저장된 최소값과 또 다른 8*8 배열에서 도출된 최소값도 비교해야 하니 전역으로 선언하는 게 맞음.
    static int totalMin = 64;

    public static void findMin(int startN, int startM) {
        int findN = startN + 8 ;
        int findM = startM + 8 ;

        // 첫번째 칸 색을 기준으로 색 변경 진행
        int changeCount = 0;
        String firstGrid = chessBoard[startN][startM];

        for(int i = startN; i < findN ; i++) {
            for(int j = startM; j < findM ; j++) {
                if(!chessBoard[i][j].equals(firstGrid))
                    changeCount++;

                //  다음 칸이면 색 변경
                if(firstGrid.equals("W"))
                    firstGrid = "B";
                else
                    firstGrid = "W";
            }
            //  다음 열로 이동 시 색 변경 8칸이라 firstGrid 가 처음 값으로 변해 있음.
            if(firstGrid.equals("W"))
                firstGrid = "B";
            else
                firstGrid = "W";
        }

        // 첫 시작이 B 일 때와 W 일 때의 최소를 비교해야 하니까 max 에서 뺀 값과 도출된 값의 최소값을 비교해야함.
        changeCount = Math.min(changeCount, 64-changeCount);

        // 기존 최소값과 다른 행과 열에서 시작점을 둔 배열 중 최소값 체크
        totalMin = Math.min(totalMin, changeCount);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        chessBoard = new String[N][M];

        // 전체 데이터 배열에 입력
        for (int i = 0; i < N; i++)
            chessBoard[i] = br.readLine().split("");

        // 만약에 10 10 입력되면
        // 0,0/0,1/0,2/1,0/1,1/1,2/2,0/2,1/2,2 이렇게 체크
        // 그러면
        int N_check = N - 7;
        int M_check = M - 7;

        for(int i = 0; i < N_check; i++){
            for(int j = 0; j < M_check; j++){
                // 여기서 찾는 로직이 돌아야 함.
                // 함수로 빼자
                findMin(i, j);
            }
        }

        bw.write(totalMin+"\n");
        bw.flush(); bw.close(); br.close();
    }
}