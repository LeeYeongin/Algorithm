import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1; // x = 열, y = 행 값
            }

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        cnt++;
                    }
                }
            }

            bw.write(cnt + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int a, int b) {
        visited[a][b] = true;

        for (int k = 0; k < 4;  k++) {
            int tmpX = a + dx[k];
            int tmpY = b + dy[k];

            if(tmpX>=0 && tmpX<N && tmpY >=0 && tmpY < M){
                if(map[tmpX][tmpY] == 1 && !visited[tmpX][tmpY])
                    dfs(tmpX, tmpY);
            }
        }
    }
}