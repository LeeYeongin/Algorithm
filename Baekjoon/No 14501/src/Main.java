import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] work;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        work = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int day, int sum) {
        // 퇴사일을 넘겼다면 종료
        if (day > N + 1) return;

        // 퇴사일이면 최대 수익 갱신
        if (day == N + 1) {
            max = Math.max(max, sum);
            return;
        }

        // 1. 오늘 상담을 선택
        if (day + work[day][0] <= N + 1) {
            dfs(day + work[day][0], sum + work[day][1]);
        }

        // 2. 오늘 상담을 선택하지 않음 (다음 날로 넘어감)
        dfs(day + 1, sum);
    }

//    static void dfs(int idx, int sum) {
//        for (int i = idx; i <= N; i++) {
//            int next = i + work[i][0];
//            if (next <= N) {
//                dfs(next, sum + work[i][1]);
//            }else if(next == N+1){
//                max = Math.max(max, sum+ work[i][1]);
//            }
//            max = Math.max(max, sum);
//        }
//    }
}