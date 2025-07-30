import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] S;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
            visited[i] = false;
        }

        dfs(0, 0);

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int idx){
        if(depth == N/2){
            min = Math.min(min, calAbs());
            return;
        }

        for(int i=idx; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    static int calAbs(){
        int team1 = 0;
        int team2 = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i] && visited[j])
                    team1 += S[i][j];
                else if(!visited[i] && !visited[j])
                    team2 += S[i][j];
            }
        }
        return Math.abs(team1-team2);
    }
}