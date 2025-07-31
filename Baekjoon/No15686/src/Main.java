import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static List<Point> selectedChickens = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int city = Integer.parseInt(st.nextToken());
                if(city == 1)
                    houses.add(new Point(i + 1, j + 1));
                else if(city == 2)
                    chickens.add(new Point(i + 1, j + 1));
            }
        }

        visited = new boolean[chickens.size()];

        dfs(0, 0);

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int idx){
        if(depth == M){
            min = Math.min(min, getChickenDistance());
            return;
        }

        for(int i=idx; i<chickens.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                selectedChickens.add(chickens.get(i));
                dfs(depth+1, i+1);
                visited[i] = false;
                selectedChickens.remove(selectedChickens.size()-1);
            }
        }
    }

    static int getChickenDistance(){
        int sum = 0;
        for(Point house: houses){
            int min = Integer.MAX_VALUE;
            for(Point chicken: selectedChickens){
                int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                min = Math.min(min,dist);
            }
            sum += min;
        }
        return sum;
    }
}