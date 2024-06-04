import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int ipv6Max = 8;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(":");
        int inputLength = input.length;
        br.close();

        String[] newInput = new String[ipv6Max];
        //2. 0으로만 이루어진 그룹이 있을 경우 연속된 그룹이 ::으로 구성됨
        int n = 0;
        int temp = 0;
        if (inputLength < ipv6Max) {
            if(input[0].isEmpty() && input[1].isEmpty()) {
                // 처음부터 중반 혹은 끝까지 0이 연속된 그룹이 존재하는 경우
                // ::으로 압축되어 있으면 입력데이터를 받을 때 1,2번째 칸에 공백처리가 되어
                // 첫번째 칸을 생략하고 두번째 칸부터 진행하게 조정
                for (int i = 1; i < inputLength; i++) {
                    if (input[i].isEmpty()) {
                        // newInput 의 첫번째 위치 부터 입력하기위해 temp 값 조정
                        temp = i-1;
                        while ((inputLength-1) + n <= ipv6Max) {
                            newInput[temp] = "0000";
                            temp++;
                            n++;
                        }
                    }
                    else {
                        newInput[temp] = input[i];
                        temp++;
                    }
                }
            }
            else {
                // 중간에 0이 연속된 그룹이 존재하는 경우
                for (int i = 0; i < inputLength; i++) {
                    if (input[i].isEmpty()) {
                        // 비어있는 값을 찾을 경우 8칸이 될 때까지 0000 입력
                        temp = i;
                        while (inputLength + n <= ipv6Max) {
                            newInput[temp] = "0000";
                            temp++;
                            n++;
                        }
                    }
                    else {
                        newInput[temp] = input[i];
                        temp++;
                    }
                }
            }
        }
        else if (inputLength > ipv6Max) {
            // 가장 앞에 :: 가 나오고 뒤에 7개의 필드가 채워져 있는 경우임.
            // 이렇게 되면 아래 로직에 의해 0000이 두개 입력되고 마지막에 입력된 필드가 작성되지 않는 현상 발생
            for (int i = 1; i < inputLength; i++) {
                if (input[i].isEmpty()) {
                    // newInput 의 첫번째 위치 부터 입력하기위해 temp 값 조정
                    temp = i-1;
                    while ((inputLength-1) + n <= ipv6Max) {
                        newInput[temp] = "0000";
                        temp++;
                        n++;
                    }
                }
                else {
                    newInput[temp] = input[i];
                    temp++;
                }
            }

        }
        else
            newInput = input;


        // 입력이 완료된 뒤에도 newInput 배열에 null 이 존재할 경우
        for (int i = 0; i < ipv6Max; i++) {
            if (newInput[i] == null)
                newInput[i] = "0000";
        }

        // 시간 부족으로 전체 다 있을 때만 구현
        // 중복으로 축약된 콜론은 작성 못함
        for (int i = 0; i < ipv6Max; i++) {
            // 1. 각 그룹의 앞자리 0 전체 또는 일부 생략된 내용 채우기
            if (newInput[i].length() != 4) {
                while(newInput[i].length() != 4)
                    newInput[i] = "0" + newInput[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : newInput)
            sb.append(s).append(":");
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}