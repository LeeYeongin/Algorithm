import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            bw.write(st.nextToken() + " ");

            List<Integer> students = new ArrayList<>();
            students.add(Integer.parseInt(st.nextToken()));

            int move = 0;
            for(int j=1; j<20; j++){
                int height = Integer.parseInt(st.nextToken());

                for(int k=0; k<students.size(); k++){
                    if(students.get(k) > height){
                        move += students.size() - k;
                        students.add(k, height);
                        break;
                    }
                }

                if(students.size() <= j){
                    students.add(height);
                }
            }

            bw.write(move + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}