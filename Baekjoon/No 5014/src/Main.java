import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static int min = -1;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[F+1];

        bfs(S);
        bw.write((min == -1 ? "use the stairs" : min) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        int[] cnt = new int[F+1];

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now  = queue.poll();

            if(now == G){
                min = cnt[now];
                break;
            }

            int up = now + U;
            int down = now - D;

            if(up <= F){
                if(!visited[up]){
                    queue.offer(up);
                    cnt[up] = cnt[now] + 1;
                    visited[up] = true;
                }
            }

            if(down > 0){
                if(!visited[down]){
                    queue.offer(down);
                    cnt[down] = cnt[now] + 1;
                    visited[down] = true;
                }
            }
        }
    }
}