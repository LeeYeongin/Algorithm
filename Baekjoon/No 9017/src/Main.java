import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] arr;

        for (int i = 0; i < T; i++) {
            HashMap<Integer, Score> result = new HashMap<>();
            HashMap<Integer, Integer> count = new HashMap<>();

            int N = Integer.parseInt((br.readLine()));
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int team = Integer.parseInt(st.nextToken());
                count.put(team, count.getOrDefault(team, 0) + 1);
                arr[j] = team;
            }

            count.entrySet().removeIf(e -> e.getValue() < 6);

            int scoreNum = 1;
            for (int j = 0; j < N; j++) {
                int team = arr[j];

                if (count.containsKey(team)) {
                    if (!result.containsKey(team)) {
                        result.put(team, new Score(new ArrayList<>(), 0));
                    }

                    Score tmp = result.get(team);
                    tmp.rank.add(scoreNum);
                    if (tmp.rank.size() <= 4)
                        tmp.sum += scoreNum;

                    scoreNum++;
                }
            }

            int winner = 0;
            int sumScore = Integer.MAX_VALUE;
            for (Integer key : result.keySet()) {
                Score s = result.get(key);

                if (sumScore == s.sum) {
                    Score w = result.get(winner);
                    winner = s.rank.get(4) < w.rank.get(4) ? key : winner;
                }

                if (sumScore > s.sum) {
                    sumScore = s.sum;
                    winner = key;
                }
            }

            bw.write(winner + "\n");


        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Score {
        List<Integer> rank;
        int sum;

        public Score(List<Integer> rank, int sum) {
            this.rank = rank;
            this.sum = sum;
        }
    }
}