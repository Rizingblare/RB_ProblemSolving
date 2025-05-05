package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PS_240418_주사위굴리기_BOJ14499 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static int N;
    private static int M;
    private static int x;
    private static int y;
    private static int K;

    private static int[][] board;
    private static String[] moves;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);
        x = Integer.parseInt(input.split(" ")[2]);
        y = Integer.parseInt(input.split(" ")[3]);
        K = Integer.parseInt(input.split(" ")[4]);

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            board[i][0] = Integer.parseInt(input.split(" ")[0]);
            board[i][1] = Integer.parseInt(input.split(" ")[1]);
        }


        input = br.readLine();
        moves = input.split(" ");

        solve();
        System.out.println(sb);

    }

    private static void solve() {
        Dice dice = new Dice();
        int currX = x;
        int currY = y;

        for (int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(moves[i]);
            int floor = 0;
            switch (cmd) {
                case 1:
                    if (currY + 1 < N) {
                        currY++;
                        floor = dice.right();
                        break;
                    }
                    else continue;
                case 2:
                    if (currY - 1 >= 0) {
                        currY--;
                        floor = dice.left();
                        break;
                    }
                    else continue;
                case 3:
                    if (currX - 1 >= 0) {
                        currX--;
                        floor = dice.up();
                        break;
                    }
                    else continue;
                case 4:
                    if (currX + 1 < N) {
                        currX++;
                        floor = dice.down();
                        break;
                    }
                    else continue;
            }
            sb.append(dice.getTop()).append("\n");
            if (board[currX][currY] == 0) {
                board[currX][currY] = floor;
            }
            else {
                dice.setFloor(board[currX][currY]);
            }
        }
    }

    private static class Dice {
        int[] floorMap;

        public Dice() {
            floorMap = new int[7];
        }

        public int left(){
            int tmp = floorMap[1];
            floorMap[1] = floorMap[3];
            floorMap[3] = floorMap[4];
            floorMap[4] = tmp;
            
            return floorMap[6];
        }

        public int right(){
            int tmp = floorMap[1];
            floorMap[1] = floorMap[4];
            floorMap[4] = floorMap[3];
            floorMap[3] = tmp;

            return floorMap[6];
        }

        public int up(){
            int tmp = floorMap[1];
            floorMap[1] = floorMap[5];
            floorMap[5] = floorMap[6];
            floorMap[6] = floorMap[2];
            floorMap[2] = tmp;

            return floorMap[6];
        }

        public int down(){
            int tmp = floorMap[1];
            floorMap[1] = floorMap[2];
            floorMap[2] = floorMap[6];
            floorMap[6] = floorMap[5];
            floorMap[5] = tmp;

            return floorMap[6];
        }

        public int getTop() {
            return floorMap[1];
        }

        public void setFloor(int floor) {
            floorMap[6] = floor;
        }
    }
}
