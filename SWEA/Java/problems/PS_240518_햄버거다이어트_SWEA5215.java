package problems;

import java.io.*;
import java.util.*;

public class PS_240518_햄버거다이어트_SWEA5215 {

    /*
        1. 아이디어:

        2. 시간 복잡도:

        3. 자료구조:

     */

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static int N;
    private static int L;

    private static int[] score;
    private static int[] cal;

    private static int max;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            score = new int[N];
            cal = new int[N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                score[j] = Integer.parseInt(st.nextToken());
                cal[j] = Integer.parseInt(st.nextToken());
            }
            max = 0;
            func(0,0,0);

            System.out.println(max);
        }

    }

    private static void func(int depth, int score_sum, int cal_sum) {
        if (cal_sum > L) return;
        if (depth == N) {
            max = Math.max(score_sum, max);
            return;
        }

        func(depth+1, score_sum + score[depth], cal_sum + cal[depth]);
        func(depth+1, score_sum, cal_sum);
    }
}
