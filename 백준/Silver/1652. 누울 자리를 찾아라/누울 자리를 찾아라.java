import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 제한 조건
        if(N < 1 || N > 100) {
            bw.write("잘못된 입력\n");
            bw.flush(); bw.close(); br.close();
        }

        // 방 초기화
        String[][] room = new String[N][N];

        // 방 상태 입력
        for(int i = 0; i < N; i++)
            room[i] = br.readLine().split("");

        br.close();

        // 가로열 누울 자리
        int rowCount = 0;
        int rowLay = 0;

        // 세로열 누울 자리
        int colCount = 0;
        int colLay = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 가로열 눕기
                if (room[i][j].equals("."))
                    rowCount++;
                else {
                    // 짐 있는 방을 만나면 rowCount 초기화
                    rowCount = 0;
                }

                if(j < N-1) {
                    // 다음 방에 짐이 있는데 rowCount 가 2 이상 일때
                    if (rowCount > 1 && !room[i][j+1].equals(".")) {
                        rowLay++;
                        rowCount = 0;
                    }
                }
                else {
                    if (rowCount > 1) {
                        rowLay++;
                        rowCount = 0;
                    }
                }

                // 세로열 눕기
                if (room[j][i].equals("."))
                    colCount++;
                else {
                    // 짐 있는 방을 만나면 colCount 초기화
                    colCount = 0;
                }

                if(j < N-1) {
                    // 다음 방에 짐이 있는데 colCount 가 2 이상 일때
                    if(colCount > 1 && !room[j+1][i].equals(".")) {
                        colLay++;
                        colCount = 0;
                    }
                }
                else {
                    if(colCount > 1) {
                        colLay++;
                        colCount = 0;
                    }
                }
            }
            rowCount = 0;
            colCount = 0;
        }
        bw.write(rowLay + " " + colLay + "\n");
        bw.flush();
        bw.close();
    }
}
