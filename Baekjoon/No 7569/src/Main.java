import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] tomato;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] dz = {1, -1};
    static int unripe = 0;
    static int days = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    int tmp = Integer.parseInt(st.nextToken());
                    tomato[i][j][k] = tmp;
                    if (tmp == 0)
                        unripe++;
                }
            }
        }

        if(unripe == 0)
            bw.write(0 + "\n");
        else{
            bfs();
            if(unripe != 0)
                bw.write(-1 + "\n");
            else
                bw.write(days + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 1) {
                        queue.offer(new Point(j, k, i));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0; s < size; s++){
                Point now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int tmpX = now.x + dx[i];
                    int tmpY = now.y + dy[i];

                    if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M) {
                        if (tomato[now.z][tmpX][tmpY] == 0) {
                            queue.offer(new Point(tmpX, tmpY, now.z));
                            tomato[now.z][tmpX][tmpY] = 1;
                            unripe--;
                        }
                    }
                }

                for (int i = 0; i < 2; i++) {
                    int tmpZ = now.z + dz[i];

                    if (tmpZ >= 0 && tmpZ < H) {
                        if (tomato[tmpZ][now.x][now.y] == 0) {
                            queue.offer(new Point(now.x, now.y, tmpZ));
                            tomato[tmpZ][now.x][now.y] = 1;
                            unripe--;
                        }
                    }
                }
            }
            days++;
        }
    }

    static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}