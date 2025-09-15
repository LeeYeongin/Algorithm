import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> game = new HashMap<>();
        game.put("Y", 1);
        game.put("F", 2);
        game.put("O", 3);


        int N = Integer.parseInt(st.nextToken());
        int gameN = game.get(st.nextToken());
        HashMap<String, String> names = new HashMap<>();

        for(int i=0; i<N; i++){
            String name = br.readLine();
            names.put(name, name);
        }

        bw.write((names.size()/gameN)+"");

        bw.flush();
        bw.close();
        br.close();
    }

}