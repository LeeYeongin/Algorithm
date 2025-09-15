import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[][] oven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        oven = new String[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                oven[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int x = 0;
        int y = 0;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (oven[i][j - 1].equals("*") && oven[i - 1][j].equals("*")
                        && oven[i][j + 1].equals("*") && oven[i + 1][j].equals("*")) {
                    x = i;
                    y = j;
                    break;
                }
            }

            if (x != 0 && y != 0) {
                break;
            }
        }

        int heartX = x+1;
        int heartY = y+1;
        bw.write(heartX + " " + heartY + "\n");

        int leftArm = 0;
        int tmpX = x;
        int tmpY = y-1;
        while(tmpY > -1 && oven[tmpX][tmpY].equals("*")){
            leftArm++;
            tmpY--;
        }
        bw.write(leftArm + " ");

        int rightArm = 0;
        tmpX = x;
        tmpY = y+1;
        while(tmpY < N && oven[tmpX][tmpY].equals("*")){
            rightArm++;
            tmpY++;
        }
        bw.write(rightArm + " ");

        int mid = countLength(x+1, y, N);
        bw.write(mid+ " ");
        bw.write(countLength(x+mid+1, y-1, N) + " ");
        bw.write(countLength(x+mid+1, y+1, N) + " ");

        bw.flush();
        bw.close();
        br.close();
    }

    static int countLength(int x, int y, int N){
        int length = 0;

        while(x < N && oven[x][y].equals("*")){
            length++;
            x++;
        }

        return  length;
    }
}