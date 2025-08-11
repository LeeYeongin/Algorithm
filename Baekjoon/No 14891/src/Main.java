import java.io.*;
import java.util.*;

public class Main {

    static List<Deque<Integer>> gear = new ArrayList<>();
    static int N;
    static List<Move> moveList = new ArrayList<>();


    static class Move {
        int gearNum;
        int direction;

        public Move(int gearNum, int direction) {
            this.gearNum = gearNum;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i=0; i<5; i++){
            gear.add(new LinkedList<>());
        }

        for(int j=1; j<5; j++){
            String line = br.readLine();
            for(int i=0; i<8; i++){
                gear.get(j).add(line.charAt(i) - '0');
            }
        }

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            moveList.add(new Move(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for(Move move : moveList){
            move(move.gearNum, move.direction);
        }

        int result = 0;
        int[] score = {1, 2, 4, 8};

        for(int j=1; j<5; j++){
            if(gear.get(j).getFirst() == 1){
                result += score[j-1];
            }
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void move(int startGear, int dir){
        int[] moveDirection = new int[5];

        moveDirection[startGear] = dir;
        int left = startGear - 1;
        int right = startGear + 1;

        while(left > 0){
            if(Objects.equals(((LinkedList<Integer>) gear.get(left)).get(2),
                    ((LinkedList<Integer>) gear.get(left + 1)).get(6))){
                moveDirection[left] = 0;
            }else{
                moveDirection[left] = -(moveDirection[left+1]);
            }

            left--;
        }

        while(right < 5){
            if(Objects.equals(((LinkedList<Integer>) gear.get(right)).get(6),
                    ((LinkedList<Integer>) gear.get(right - 1)).get(2))){
                moveDirection[right] = 0;
            }else{
                moveDirection[right] = -(moveDirection[right-1]);
            }

            right++;
        }

        for(int i=1; i<=4; i++){
            if(moveDirection[i] == 1){
                gear.get(i).addFirst(gear.get(i).getLast());
                gear.get(i).removeLast();
            }

            if(moveDirection[i] == -1){
                gear.get(i).addLast(gear.get(i).getFirst());
                gear.get(i).removeFirst();
            }
        }
    }
}