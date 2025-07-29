import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] num;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        op = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, num[0]);

        bw.write(max + "\n");
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int result){
        if(depth == N){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for(int i=0; i<4; i++){
            if(op[i] > 0){
                op[i]--;
                int tmp = 0;
                switch (i){
                    case 0:
                        tmp = result + num[depth];
                        break;
                    case 1:
                        tmp = result - num[depth];
                        break;
                    case 2:
                        tmp = result * num[depth];
                        break;
                    case 3:
                        if(result < 0)
                            tmp = -(-result / num[depth]);
                        else
                            tmp = result / num[depth];
                        break;
                }
                dfs(depth+1, tmp);
                op[i]++;
            }
        }
    }
}