import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> dp = new ArrayList<>();

        dp.add(1);  // dp[0]
        dp.add(1);  // dp[1]
        dp.add(3);  // dp[2]

        if(n < 3){
            bw.write(dp.get(n) + "\n");
        }
        else{
            for(int i=3; i<=n; i++){
                int cnt = dp.get(i-1) + dp.get(i-2) * 2;
                dp.add(cnt % 10007);
            }
            bw.write(dp.get(n) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}