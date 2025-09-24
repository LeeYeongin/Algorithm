import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> cards = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            cards.add(i);
        }

        while (cards.size() > 1) {
            cards.removeFirst();
            cards.add(cards.removeFirst());
        }

        bw.write(cards.getFirst() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}