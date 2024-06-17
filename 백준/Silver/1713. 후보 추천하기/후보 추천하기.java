import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N,R;
    static class Recommend implements Comparable<Recommend>{
        int order;
        int studentNumber;
        int count;
        public Recommend(int order, int studentNumber, int count) {
            this.order = order;
            this.studentNumber = studentNumber;
            this.count = count;
        }
        @Override
        public int compareTo(Recommend recommend) {
            // count 오름차순으로 정렬하되 count 가 같을 경우 먼저 추천받은 순서대로 정렬
            if(this.count == recommend.count)
                return this.order - recommend.order;

            return this.count - recommend.count;
        }
    }

    static ArrayList<Recommend> recommends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 사진틀 개수
        R = Integer.parseInt(br.readLine()); // 추천 횟수

        // 데이터 입력
        recommends = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < R; i++) {
            int candidate = Integer.parseInt(input[i]);
            // 이미 존재하는 후보자일 경우 count 만 늘리고 넘기기
            if (duplicateCheck(candidate)) continue;

            // 정렬조건 override 로 수정해 둠.
            Collections.sort(recommends);

            if (recommends.size() == N)
                recommends.remove(0); // 추천 수가 가장 적은 후보자 삭제

            recommends.add(new Recommend(i, candidate, 1));
        }

        // 출력
        ArrayList<Integer> output = new ArrayList<>();
        for(Recommend recommend : recommends)
            output.add(recommend.studentNumber);

        Collections.sort(output);
        for (int number : output)
            System.out.print(number +" ");
        br.close();
    }

    public static boolean duplicateCheck(int candidate){
        for(Recommend r : recommends) {
            if(r.studentNumber == candidate) {
                r.count++;
                return true;
            }
        }
        return false;
    }
}