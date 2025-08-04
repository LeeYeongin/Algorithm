import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<Integer> dfsResult = new ArrayList<>();
    static List<Integer> bfsResult = new ArrayList<>();
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;

    static List<List<Integer>> graph = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        dfsVisited = new boolean[N+1];
        bfsVisited = new boolean[N+1];

        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        for(int i=1; i<N+1; i++){
           Collections.sort(graph.get(i));
        }

        dfs(V);
        bfs(V);

        for(int node: dfsResult){
            bw.write(node + " ");
        }
        bw.write("\n");

        for(int node: bfsResult){
            bw.write(node + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int index){
        if(!dfsVisited[index]){
            dfsVisited[index] = true;
            dfsResult.add(index);
            for(int i=0; i<graph.get(index).size(); i++){
                dfs(graph.get(index).get(i));
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        bfsVisited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            bfsResult.add(current);

            for(int next:graph.get(current)){
                if(!bfsVisited[next]){
                    bfsVisited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}