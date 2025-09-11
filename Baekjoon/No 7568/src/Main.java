import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            persons.add(new Person(weight, height));
        }

        for(int i=0; i<N; i++){
            Person p = persons.get(i);
            int cnt = 1;
            for(int j=0; j<N; j++){
                if(i == j)
                    continue;

                Person tmp = persons.get(j);
                if(p.height < tmp.height && p.weight < tmp.weight)
                    cnt++;
            }

            bw.write(cnt + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Person{
        int weight;
        int height;

        public Person (int weight, int height){
            this.weight = weight;
            this.height = height;
        }
    }
}