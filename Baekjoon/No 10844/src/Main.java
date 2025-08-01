import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MOD = 1_000_000_000;
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[10];
        for(int i=1; i<10; i++){
            dp[i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            int[] next = new int[10];
            next[0] = dp[1] % MOD;
            for (int j = 1; j < 9; j++) {
                next[j] = (dp[j - 1] + dp[j + 1]) % MOD;
            }
            next[9] = dp[8] % MOD;
            dp = next;
        }

        int result = 0;
        for(int i = 0; i < 10; i++)
            result = (result + dp[i]) % MOD;

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}