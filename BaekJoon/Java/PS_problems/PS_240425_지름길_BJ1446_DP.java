package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PS_240425_지름길_BJ1446_DP {
    // 1. 아이디어 - dp[D]까지 걸리는 최소 시간을 찾는 다이나믹 프로그래밍
    // 2. 시간복잡도 - O(N) 10000 < 100,000,000
    // 3. 자료구조 - 최대 10000 int


    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dp = new int[D+1];
        int[][] shortcut = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            shortcut[i][0] = Integer.parseInt(st.nextToken());
            shortcut[i][1] = Integer.parseInt(st.nextToken());
            shortcut[i][2] = Integer.parseInt(st.nextToken());
        }



    }
}
