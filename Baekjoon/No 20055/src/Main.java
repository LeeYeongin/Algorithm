import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] belt = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] robot = new boolean[N];
        int step = 0;

        while (true) {
            step++;

            int last = belt[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = last;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            for (int i = N - 2; i >= 0; i--) {
                if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    belt[i + 1]--;
                }
            }
            robot[N - 1] = false;

            if (!robot[0] && belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            int cnt = 0;
            for(int i=0; i<2*N; i++){
                if(belt[i] == 0)
                    cnt++;
            }

            if(cnt >= K)
                break;
        }


        bw.write(step + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}