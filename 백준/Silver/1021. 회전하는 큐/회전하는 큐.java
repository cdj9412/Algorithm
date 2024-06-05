import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
     * 예시)
     * 1 3
     * 2 9 5
     * 초기 상태 [1,2,3,4,5,6,7,8,9,10]
     * 먼저 2를 뽑으려면 1을 뒤로 보내야함. + 1(2번 연산) [2,3,4,5,6,7,8,9,10,1]
     * 2 뽑기 (1번 연산) [3,4,5,6,7,8,9,10,1]
     * * 2번 연산과 3번 연산 중 3번 연산을 선택하려면 중간을 기준으로 뽑으려는 수의 위치가 뒤에 있는지 앞에 있는지 판단해야 함.
     * 9를 뽑으려면 1,10,9을 앞으로 +3(3번연산) [9,10,1,3,4,5,6,7,8]
     * 9 뽑기 (1번 연산) [10,1,3,4,5,6,7,8]
     * * 2번 연산과 3번 연산 중 3번 연산을 선택하려면 중간을 기준으로 뽑으려는 수의 위치가 뒤에 있는지 앞에 있는지 판단해야 함.
     * 5를 뽑으려면 8,7,6,5를 앞으로 +4(3번연산) [5,6,7,8,10,1,3,4]
     * 5 뽑기 (1번 연산)
     *
     * 이건 앞에 프린터 큐 사용했던 것처럼 LinkedList 나 deque 활용해서 구현하면 될듯?
     * 앞에선 LinkedList 써봤으니까 여기선 deque 로 구현
     * 이것도 queue 랑 비슷하게 인덱스에 접근이 안되어서... LinkedList 로 구현해야 할듯
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려는 원소의 위치

        // 더미 데이터 입력
        LinkedList<Integer> deque = new LinkedList<>();
        // 인덱스 비교용 LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++){
            deque.add(i);
            list.add(i);
        }
        
        //뽑아내려는 위치 저장
        int targetIndex = 0;
        int calcCount = 0;
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < M; i++){
            // 인덱스라서 -1 진행
            targetIndex = Integer.parseInt(st.nextToken()) - 1;
            int dequeIndexHalf = deque.size() / 2;

            // 원소가 빠진 상태의 deque 에서 인덱스 위치가 절반 보다 작거나 같을 때
            if(deque.indexOf(list.get(targetIndex)) <= dequeIndexHalf){
                // 뽑아내려는 인덱스가 절반보다 작거나 같으면 2번 연산 수행
                while(list.get(targetIndex) != deque.getFirst()){
                    deque.addLast(deque.removeFirst());
                    calcCount++;
                }
            }
            else {
                // 뽑아내려는 인덱스가 절반보다 크면 3번 연산 수행
                while(list.get(targetIndex) != deque.getFirst()){
                    deque.addFirst(deque.removeLast());
                    calcCount++;
                }
            }
            deque.removeFirst();
        }
        System.out.println(calcCount);
    }
}
