import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class pillar {
        int left;
        int height;
        public pillar(int left, int height) {
            this.left = left;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<pillar> pillars = new ArrayList<>();
        int maxHeight = 0;
        for (int i = 0; i < N; i++) { // O(N)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            // 전체 기둥 데이터 입력
            pillars.add(new pillar(L, H));

            // 가장 긴 기둥 높이 저장
            if (maxHeight < H)
                maxHeight = H;
        }

        // left 좌표 기준으로 정렬
        pillars.sort(Comparator.comparingInt(o -> o.left)); //O(NogN)

        int areaSize = 0;
        // 높은 기둥 기준 앞 쪽
        pillar highest = pillars.get(0);
        int pillarCount = pillars.size();
        for(int i = 0; i < pillarCount; i++) { //O(N)
            pillar current = pillars.get(i);

            // 같은 최대 높이의 기둥이 두 개이상 있을 경우를 생각해서 등호 포함
            if(highest.height <= current.height) {
                areaSize += (current.left - highest.left) * highest.height;
                highest = current;
            }
        }

        // 높은 기둥 기준 뒤 쪽
        highest = pillars.get(pillarCount - 1);
        for(int i = pillarCount - 2; i >= 0; i--) {
            pillar current = pillars.get(i);

            // 같은 최대 높이의 기둥이 두 개이상 있을 경우를 생각해서 등호 포함
            if(highest.height < current.height) {
                areaSize += (highest.left - current.left) * highest.height;
                highest = current;
            }
        }

        areaSize+=maxHeight;
        System.out.println(areaSize);
        br.close();
    }
}