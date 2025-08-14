import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, p1, p2;
    static List<List<Integer>> family = new ArrayList<>();
    static boolean[] visited;
    static int cnt = -1;
    static boolean exited = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for(int i=0; i<N+1; i++){
            family.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            family.get(num1).add(num2);
            family.get(num2).add(num1);
        }

        for(int i=1; i<M+1; i++){
            Collections.sort(family.get(i));
        }

        dfs(p1, 0);

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start, int count){
        if(start == p2){
            cnt = count;
            return;
        }

        visited[start] = true;

        for(int next: family.get(start)){
            if(!visited[next]){
                dfs(next, count+1);
            }
        }
    }
}