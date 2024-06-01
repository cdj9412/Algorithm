import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputData = br.readLine();
        br.close();

        if(inputData.isEmpty() || inputData.length() >100) {
            bw.write("잘못된 입력\n");
            return;
        }

        for(int i = 0; i < inputData.length(); i++){
            bw.write(inputData.charAt(i));
            if((i + 1) % 10 == 0)
                bw.newLine();
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
