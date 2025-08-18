import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = 1; // rain이 0일 경우를 고려
    static int[][] region;
    static boolean[][] visited;
    static int rain = 1;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        region = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = -1;
        while (cnt != 0 && rain <= 100) {
            visited = new boolean[N][N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (region[i][j] > rain && !visited[i][j]) {
                        dfs(i, j, rain);
                        cnt++;
                    }
                }
            }

            max = Math.max(max, cnt);
            rain++;
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, int rain) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];

            if (x >= 0 && x < N && y >= 0 && y < N) {
                if (region[x][y] > rain && !visited[x][y])
                    dfs(x, y, rain);
            }
        }
    }
}