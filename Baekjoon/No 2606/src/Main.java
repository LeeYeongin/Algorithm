import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<List<Integer>> linked = new ArrayList<>();
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            linked.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            linked.get(com1).add(com2);
            linked.get(com2).add(com1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(linked.get(i));
        }

        // BFS
//        bfs(1);
//        bw.write(cnt + "\n");

        // DFS
        dfs(1);
        bw.write(cnt-1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start) {
        Queue<Integer> visitedCom = new LinkedList<>();

        visitedCom.offer(start);
        visited[start] = true;

        while (!visitedCom.isEmpty()) {
            int num = visitedCom.poll();
            for (int com : linked.get(num)) {
                if (!visited[com]) {
                    visitedCom.offer(com);
                    visited[com] = true;
                    cnt++;
                }
            }
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        cnt++;

        for (int com : linked.get(start)) {
            if(!visited[com])
                dfs(com);
        }
    }
}