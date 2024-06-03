import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st ;

    static int[][] A ;
    static int[][] B ;

    static void ArraySet(int[][] Array) throws IOException {
        int RowCount = Array.length ;
        int ColCount = Array[0].length ;

        // 제한시간은 1초이지만 행렬의 크기가 100을 넘지 않으니 이중 반복까지는 괜찮음.
        for ( int i = 0; i < RowCount; i++) {
            // 원소 가져오기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < ColCount; j++) {
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 제한 조건
        if (Math.abs(N) < 1 || Math.abs(N) > 100
            ||Math.abs(M) < 1 || Math.abs(M) > 100)
        {
            bw.write("잘못된 입력\n");
            bw.flush(); bw.close(); br.close();
            return;
        }

        A = new int[N][M];
        B = new int[N][M];

        // 행렬 A 채우기
        ArraySet(A);
        // 행렬 B 채우기
        ArraySet(B);

        // 행렬 A+B 를 수행 및 값 저장
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sb.append(A[i][j] + B[i][j]).append(" ");
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}