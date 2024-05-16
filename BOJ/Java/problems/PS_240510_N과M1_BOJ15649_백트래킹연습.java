package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
    1. 아이디어:

    2. 시간 복잡도:

    3. 자료구조:

 */


public class PS_240510_N과M1_BOJ15649_백트래킹연습 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static int N;
    private static int M;

    private static Integer[] arr;
    private static boolean[] isused;
    private static List<Integer[]> answer;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Integer[M];
        isused = new boolean[N+1];
        answer = new ArrayList<>();
        backtrack(0);

        for (Integer[] a : answer) {
            for (int i : a) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void backtrack(int len) {
        if (len == M) {
            answer.add(arr.clone());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isused[i]) {
                isused[i] = true;
                arr[len] = i;
                backtrack(len+1);
                isused[i] = false;

            }
        }
    }

}
