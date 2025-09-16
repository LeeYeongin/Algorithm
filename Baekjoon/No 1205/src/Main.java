import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int tScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        List<Integer> scores = new ArrayList<>();

        if(N != 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scores.add(Integer.parseInt(st.nextToken()));
            }
        }
        scores.add(tScore);

        scores.sort(Comparator.reverseOrder());

        int idx = scores.lastIndexOf(tScore);
        int rank = idx+1;
        if(rank > P){
            rank = -1;
        }else{
            int same = 0;
            while(idx > 0){
                if(scores.get(idx-1) == tScore){
                    same++;
                    idx--;
                }
                else
                    break;
            }
            rank -= same;
        }

        bw.write(rank + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}