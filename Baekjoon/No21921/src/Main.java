import java.io.*;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] viewCount = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            viewCount[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<X; i++){
            sum += viewCount[i];
        }

        int idx = X;
        int max = sum;
        int cnt = 1;
        while(idx < N){
            sum = sum - viewCount[idx-X] + viewCount[idx];

            if(max < sum){
                max = sum;
                cnt = 1;
            }else if(max == sum){
                cnt++;
            }

            idx++;
        }

        if(max == 0){
            bw.write("SAD");
        }
        else{
            bw.write(max + "\n");
            bw.write(cnt + "\n");
        }

        bw.flush(); // 남아있는 데이터 모두 출력
        bw.close(); // 스트림 닫기
        br.close(); // 스트림 닫기
    }
}