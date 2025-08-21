import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        if(num % 2 ==0){
            bw.write( "CY\n");
        }else{
            bw.write("SK\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}