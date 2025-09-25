import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] x = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            x[i] = Integer.parseInt(st.nextToken());
        }

        int max = Math.max(x[0]-0, N-x[M-1]);

        for(int i=1; i<M; i++){
            int between = (x[i]-x[i-1]+1)/2;
            max = Math.max(max, between);
        }
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}