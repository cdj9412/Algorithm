import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 상한 200 N^4까진 문제없음
    // 세가지의 폭탄 지도가 반복됨.
    public static class BombMap {
        char bomb;
        int timer;
        public BombMap(char bomb, int timer) {
            this.bomb = bomb;
            this.timer = timer;
        }
    }
    static int R,C,N;

    static BombMap[][] bombmap ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 행 수
        C = Integer.parseInt(st.nextToken()); // 열 수
        N = Integer.parseInt(st.nextToken()); // 격자판 확인 초

        bombmap = new BombMap[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++)
                bombmap[i][j] = new BombMap(line.charAt(j),0);
        }

        // 1초 후에는 맵 상태가 동일함
        if (N == 1) {
            printMap();
            return ;
        }

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 1)
                progress4(i);
            else
                progress3();
        }
        printMap();

    }

    // 3번 작업
    public static void progress3(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 빈칸 폭탄 배치
                // 일단 들어온 순간 타이머
                if (bombmap[i][j].bomb != 'O')
                    bombmap[i][j].bomb = 'O';
                else
                    bombmap[i][j].timer++;

            }
        }
    }

    // 4번 작업
    public static void progress4(int second){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombmap[i][j].bomb == 'O')
                    bombmap[i][j].timer++;
            }
        }
        if(second == 1)
            return;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(bombmap[i][j].timer == 3) {
                    // 폭탄 폭발
                    bombmap[i][j].bomb = '.';
                    bombmap[i][j].timer = 0;

                    if (j < C - 1) {
                        // 위
                        if(bombmap[i][j + 1].timer != 3) {
                            bombmap[i][j + 1].bomb = '.';
                            bombmap[i][j + 1].timer = 0;
                        }
                    }
                    if (i > 0) {
                        // 왼쪽
                        if(bombmap[i - 1][j].timer != 3) {
                            bombmap[i - 1][j].bomb = '.';
                            bombmap[i - 1][j].timer = 0;
                        }
                    }
                    if (i < R - 1) {
                        // 오른쪽
                        if(bombmap[i + 1][j].timer != 3) {
                            bombmap[i + 1][j].bomb = '.';
                            bombmap[i + 1][j].timer = 0;
                        }
                    }
                    if (j > 0) {
                        // 아래
                        if(bombmap[i][j - 1].timer != 3) {
                            bombmap[i][j - 1].bomb = '.';
                            bombmap[i][j - 1].timer = 0;
                        }
                    }

                }

            }
        }

    }

    public static void printMap() {
        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                System.out.print(bombmap[j][k].bomb);
            }
            System.out.println();
        }
    }

}