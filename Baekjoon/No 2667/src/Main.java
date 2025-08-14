import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(result);

        bw.write(result.size() + "\n");
        for (int cnt : result) {
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int r, int c) {
        Queue<Point> pointQueue = new LinkedList<>();
        int cnt = 0;

        visited[r][c] = true;
        pointQueue.offer(new Point(r, c));
        cnt++;

        while (!pointQueue.isEmpty()) {
            Point tmp = pointQueue.poll();

            for (int i = 0; i < 4; i++) {
                int x = tmp.x + dx[i];
                int y = tmp.y + dy[i];

                if (x > -1 && x < N && y > -1 && y < N) {
                    if (!visited[x][y] && map[x][y] == 1) {
                        pointQueue.offer(new Point(x, y));
                        visited[x][y] = true;
                        cnt++;
                    }
                }
            }
        }

        result.add(cnt);
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