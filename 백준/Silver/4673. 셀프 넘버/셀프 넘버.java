import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    //데이터 수 제한이 10000이라서 O(N^2)까진 가능
    static HashSet<Integer> set = new HashSet<>();
    static ArrayList<Integer> nonSelfNumber ;
    public static void main(String[] args) {
        // 데이터 셋 입력
        for (int i = 1; i <= 10000; i++)
            set.add(i);

        nonSelfNumber = new ArrayList<>();
        for (int value : set)
            checkSelfNumber(value);

        for(int nonSelf : nonSelfNumber)
            set.remove(nonSelf);

        for (int value : set)
            System.out.println(value);

    }
    static void checkSelfNumber(int number) {
        int makeNumber = number; // 기존 값에
        while (number != 0) {
            makeNumber += number % 10; // 각 자리의 값을 더하기
            number /= 10;
        }
        nonSelfNumber.add(makeNumber);
    }
}