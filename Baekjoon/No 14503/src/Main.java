import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int d, r, c;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean dirty = false;
            int x, y;

            if (map[r][c] == 0) {      // 현재 자리가 더러우면 청소
                map[r][c] = 2;
                cnt++;
            }

            // 4방향 중 청소해야할 방향이 있는지 탐색
            int tmpD = d;
            for (int i = 0; i < 4; i++) {
                tmpD = (tmpD + 3) % 4;
                x = r + dx[tmpD];
                y = c + dy[tmpD];
                if (map[x][y] == 0) {
                    dirty = true;
                    d = tmpD;
                    break;
                }
            }

            if (!dirty) {   // 청소할 구역이 없을 때
                // 뒤로 이동
                x = r + dx[(d + 2) % 4];
                y = c + dy[(d + 2) % 4];

                if (map[x][y] != 1) {
                    r = x;
                    c = y;
                } else {
                    break;  // 이동이 불가하면 출력
                }
            } else {
                // 청소할 구역이 있을 때, 청소할 구역으로 이동
                r += dx[d];
                c += dy[d];
            }
        }


        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}