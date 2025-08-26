import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] n = new int[T];
        int[] dp = new int[12];

        for(int i=0; i<T; i++){
            n[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i=0; i<T; i++){
            int num = n[i];
            bw.write(dp[num] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}