import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Movement {
        int x;
        int y;
        char direction;
        public Movement(int x, int y, char direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
    // 최초 위치와 L과 R 없이 움직이는 좌표 초기화
    //north south east west
    static Movement turtle ;
    static Movement F ; // 해당 커맨드 발생 시 이동 방향
    static Movement B ; // 해당 커맨드 발생 시 이동 방향
    static int xMax, xMin, yMax, yMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            xMax = 0; xMin = 0;
            yMax = 0; yMin = 0;
            turtle = new Movement(0,0, 'N');
            F = new Movement(0,1, 'N');
            B = new Movement(0,-1, 'N');
            commandExecute(br.readLine());
            sb.append(calcRectangle()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int calcRectangle() {
        int xLength = Math.abs(xMax) + Math.abs(xMin);
        int yLength = Math.abs(yMax) + Math.abs(yMin);
        return xLength * yLength;
    }

    public static void commandExecute(String commands) {
        int commandLength = commands.length();
        for (int i = 0; i < commandLength; i++) {
            char command = commands.charAt(i);

            switch (command) {
                case 'F':
                    turtle.x += F.x;
                    turtle.y += F.y;
                    break;
                case 'B':
                    turtle.x += B.x;
                    turtle.y += B.y;
                    break;
                case 'L':
                    switch (turtle.direction) {
                        case 'E':
                            turtle.direction = 'N';
                            F.direction = 'N';
                            F.x = 0; F.y = 1;
                            B.direction = 'N';
                            B.x = 0; B.y = -1;
                            break;
                        case 'W':
                            turtle.direction = 'S';
                            F.direction = 'S';
                            F.x = 0; F.y = -1;
                            B.direction = 'S';
                            B.x = 0; B.y = 1;
                            break;
                        case 'S':
                            turtle.direction = 'E';
                            F.direction = 'E';
                            F.x = 1; F.y = 0;
                            B.direction = 'E';
                            B.x = -1; B.y = 0;
                            break;
                        case 'N':
                            turtle.direction = 'W';
                            F.direction = 'W';
                            F.x = -1; F.y = 0;
                            B.direction = 'W';
                            B.x = 1; B.y = 0;
                            break;
                        default : break;
                    }
                    break;
                case 'R':
                    switch (turtle.direction) {
                        case 'E':
                            turtle.direction = 'S';
                            F.direction = 'S';
                            F.x = 0; F.y = -1;
                            B.direction = 'S';
                            B.x = 0; B.y = 1;
                            break;
                        case 'W':
                            turtle.direction = 'N';
                            F.direction = 'N';
                            F.x = 0; F.y = 1;
                            B.direction = 'N';
                            B.x = 0; B.y = -1;
                            break;
                        case 'S':
                            turtle.direction = 'W';
                            F.direction = 'W';
                            F.x = -1; F.y = 0;
                            B.direction = 'W';
                            B.x = 1; B.y = 0;
                            break;
                        case 'N':
                            turtle.direction = 'E';
                            F.direction = 'E';
                            F.x = 1; F.y = 0;
                            B.direction = 'E';
                            B.x = -1; B.y = 0;
                            break;
                        default : break;
                    }
                    break;
                default: break;
            }

            xMax = maxValueCheck(xMax, turtle.x);
            yMax = maxValueCheck(yMax, turtle.y);
            xMin = minValueCheck(xMin, turtle.x);
            yMin = minValueCheck(yMin, turtle.y);
        }
    }

    public static int maxValueCheck(int existValue, int changeValue){
        int maxValue = existValue;
        if (changeValue > maxValue)
            maxValue = changeValue;
        return maxValue;
    }

    public static int minValueCheck(int existValue, int changeValue){
        int minValue = existValue;
        if (changeValue < minValue)
            minValue = changeValue;
        return minValue;
    }

}