package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PS_240416_오리_BJ12933 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String sound = br.readLine();

        if (sound.charAt(0) != 'q' || sound.length() % 5 != 0) {
            sb.append(-1);
        }
        int maxCnt = 0;
        List<Duck> ducks = new ArrayList<>();
        HashMap<Character, Integer> ducksound = new HashMap<>();
        ducksound.put('q',0);
        ducksound.put('u',1);
        ducksound.put('a',2);
        ducksound.put('c',3);
        ducksound.put('k',4);


        for (int i = 0; i < sound.length(); i++) {
            char c = sound.charAt(i);

            if (c == 'q') {
                Duck duck = new Duck();
                duck.firstHowling();
                ducks.add(duck);

                if (ducks.size() > maxCnt) {
                    maxCnt = ducks.size();
                }
            }

            else if (c == 'k') {
                for (Duck duck : ducks) {
                    if (duck.isHowling(ducksound.get(c))) {
                        ducks.remove(duck);
                        break;
                    }
                }
            }

            else {
                boolean flag = false;
                for (Duck duck : ducks) {
                    if (duck.isHowling(ducksound.get(c))) {
                        duck.nextHowling(ducksound.get(c));
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    if (sb.length() == 0){
                        sb.append(-1);
                    }
                    break;
                }
            }
        }
        if (sb.length() == 0) sb.append(maxCnt);
        System.out.println(sb);
    }

    static class Duck {
        int ptr;

        public Duck() {
            int ptr = 0;
        }

        public void firstHowling() {
            ptr++;
        }
        public void nextHowling(int i) {
            if (i == ptr) ptr++;
        }
        public boolean isHowling(int i){
            return i == ptr;
        }
    }
}
