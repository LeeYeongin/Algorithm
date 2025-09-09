import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        for(int i=1; i<words.length; i++){
            int same = Arrays.stream(words).toList().indexOf(words[i]);

            if(same != i ||
                    words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                int person = (i+1) % n;
                int turn = (i+1) / n;
                answer[0] = person == 0 ? n : person;
                answer[1] = person == 0 ? turn : turn + 1;
                return answer;
            }

        }

        return answer;
    }
}