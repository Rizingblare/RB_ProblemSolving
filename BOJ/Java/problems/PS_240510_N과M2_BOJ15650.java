package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PS_240510_N과M2_BOJ15650 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static int N;
    private static int M;

    private static Integer[] arr;
    private static boolean[] isused;
    private static List<Integer[]> answer;

    private static void func(int k) {
        if (k == M) {
            answer.add(arr.clone());
            return;
        }

        int st = 1 ;
        if (k > 0) st = arr[k-1];
        for (int i = st; i <= N; i++) {
            if (isused[i]) continue;
            arr[k] = i;
            isused[i] = true;
            func(k+1);
            isused[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Integer[M];
        isused = new boolean[N+1];
        answer = new ArrayList<>();
        func(0);

        for (Integer[] a : answer) {
            for (int i : a) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

}
