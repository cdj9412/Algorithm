import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int inputLength = input.length();
        int count = 0;
        for (int i = 0; i < inputLength; i++) {
            char compareChar = input.charAt(i);


            if (compareChar == 'c'){
                if(i < inputLength-1) {
                    if (input.charAt(i + 1) == '=' || input.charAt(i + 1) == '-')
                        i++;
                }
            }
            else if (compareChar == 'l'){
                if(i < inputLength-1) {
                    if (input.charAt(i + 1) == 'j')
                        i++;
                }
            }
            else if (compareChar == 'n'){
                if(i < inputLength-1) {
                    if (input.charAt(i + 1) == 'j')
                        i++;
                }
            }
            else if (compareChar == 's'){
                if(i < inputLength-1) {
                    if (input.charAt(i + 1) == '=')
                        i++;
                }
            }
            else if (compareChar == 'z'){
                if(i < inputLength-1) {
                    if (input.charAt(i + 1) == '=')
                        i++;
                }
            }
            else if (compareChar == 'd'){
                if(i < inputLength-1) {
                    if (input.charAt(i + 1) == 'z') {
                        //dz는 무조건 하나의 알파벳으로 쓰이고, d와 z가 분리된 것으로 보지 않는다.
                        if(i < inputLength-2) {
                            if (input.charAt(i + 2) == '=')
                                i += 2;
                        }
                    } else if (input.charAt(i + 1) == '-')
                        i++;
                }
            }
            count++ ;
        }
        System.out.println(count);
        br.close();
    }
}