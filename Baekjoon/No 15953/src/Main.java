import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] numA = {1, 2, 3, 4, 5, 6};
        int[] moneyA = {500, 300, 200, 50, 30, 10};
        int[] numB = {1, 2, 4, 8, 16};
        int[] moneyB = {512, 256, 128, 64, 32};

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int total = 0;

            if (a > 0) {
                for (int j = 0; j < numA.length; j++) {
                    a -= numA[j];
                    if (a <= 0) {
                        total += moneyA[j];
                        break;
                    }
                }
            }

            if (b > 0) {
                for (int j = 0; j < numB.length; j++) {
                    b -= numB[j];
                    if (b <= 0) {
                        total += moneyB[j];
                        break;
                    }
                }
            }

            bw.write(total * 10000 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}