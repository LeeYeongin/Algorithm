import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] medal = new int[N][4];

        int idx = -1;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            medal[i][0] = Integer.parseInt(st.nextToken());
            if(medal[i][0] == c)
                idx = i;

            medal[i][1] = Integer.parseInt(st.nextToken());
            medal[i][2] = Integer.parseInt(st.nextToken());
            medal[i][3] = Integer.parseInt(st.nextToken());
        }

        int rank = 1;
        for(int i=0; i<N; i++){
            if(i == idx)
                continue;

            if(medal[i][1] > medal[idx][1]){
                rank++;
                continue;
            }

            if(medal[i][1] < medal[idx][1])
                continue;

            if(medal[i][1] == medal[idx][1]){
                if(medal[i][2] > medal[idx][2]){
                    rank++;
                    continue;
                }

                if(medal[i][2] < medal[idx][2])
                    continue;

                if(medal[i][2] == medal[idx][2]){
                    if(medal[i][3] > medal[idx][3])
                        rank++;
                }
            }
        }


        bw.write(rank + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}