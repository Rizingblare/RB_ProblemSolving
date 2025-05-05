package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS_240423_돌게임_BOJ9655_DP {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        char[] dp = new char[1001];

        dp[1] = 's';
        dp[2] = 'c';
        dp[3] = 's';

        for (int i = 4; i <= N; i++) {
            if (dp[i-1] == 's' && dp[i-3] == 's') {
                dp[i] = 's';
            }
            else {
                dp[i] = 'c';
            }
        }

        String winner = "";
        if (dp[N] == 's') winner = "SK";
        else winner = "CY";

        System.out.println(winner);
    }
}
