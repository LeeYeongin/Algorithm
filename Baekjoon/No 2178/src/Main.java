import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        int[][] dist = new int[N][M];

        visited[x][y] = false;
        queue.offer(new Point(x, y));
        dist[x][y] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                cnt = dist[now.x][now.y];
                return;
            }


            for (int i = 0; i < 4; i++) {
                int tmpX = now.x + dx[i];
                int tmpY = now.y + dy[i];

                if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M) {
                    if (maze[tmpX][tmpY] == 1 && !visited[tmpX][tmpY]) {
                        queue.offer(new Point(tmpX, tmpY));
                        visited[tmpX][tmpY] = true;
                        dist[tmpX][tmpY] = dist[now.x][now.y] + 1;
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}