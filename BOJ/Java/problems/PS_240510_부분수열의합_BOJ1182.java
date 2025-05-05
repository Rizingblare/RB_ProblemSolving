package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PS_240510_부분수열의합_BOJ1182 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int S;
    private static int cnt;
    private static int[] arr;

    private static void func(int len, int sum) {
        if (len == N) {
            if (sum == S) cnt++;
            return;
        }

        func(len+1, sum);
        func(len+1, sum+arr[len]);

    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        func(0,0);
        if (S == 0) cnt--;
        System.out.println(cnt);
    }


}
