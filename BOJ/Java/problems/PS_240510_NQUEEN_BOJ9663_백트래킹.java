package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS_240510_NQUEEN_BOJ9663_백트래킹 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] board;
    private static boolean[] isused1;
    private static boolean[] isused2;
    private static boolean[] isused3;


    private static int cnt;

    private static void func(int i) {
        if (i == N) {
            cnt++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (isused1[j] || isused2[i+j] || isused3[i-j+N-1]) continue;
            board[i][j] = 1;
            isused1[j] = true;
            isused2[i+j] = true;
            isused3[i-j+N-1] = true;
            func(i+1);
            isused1[j] = false;
            isused2[i+j] = false;
            isused3[i-j+N-1] = false;

        }

    }



    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        isused1 = new boolean[N];
        isused2 = new boolean[N*2-1];
        isused3 = new boolean[N*2-1];

        func(0);
        System.out.println(cnt);

    }
}
