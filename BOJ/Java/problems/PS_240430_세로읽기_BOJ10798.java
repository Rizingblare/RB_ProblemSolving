package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS_240430_세로읽기_BOJ10798 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        char[][] arr = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                char curr = arr[j][i];
                if (curr == 0) continue;
                sb.append(curr);
            }
        }

        System.out.println(sb);
    }
}
