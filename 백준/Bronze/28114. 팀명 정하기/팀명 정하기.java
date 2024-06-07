import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static final int memberCount = 3;
    static TreeSet<Integer> teamNameSet;
    static TreeMap<Integer, String> teamNameMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        teamNameSet = new TreeSet<>(); // 입학년도로 만드는 팀명
        teamNameMap = new TreeMap<>((o1,o2)->{
            return o2-o1;
        }); // 문제 수와 이름으로 만드는 팀명

        for (int i = 0; i < memberCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            teamNameSet.add(Y);
            teamNameMap.put(P, S);
        }

        teamNameFirst();
        teamNameSecond();
    }

    static void teamNameFirst() {
        sb = new StringBuilder();
        for(int year : teamNameSet)
            sb.append(year%100);

        System.out.println(sb);
    }

    static void teamNameSecond() {
        sb = new StringBuilder();
        for(Map.Entry<Integer, String> entry : teamNameMap.entrySet())
            sb.append(entry.getValue().charAt(0));

        System.out.println(sb);
    }
}