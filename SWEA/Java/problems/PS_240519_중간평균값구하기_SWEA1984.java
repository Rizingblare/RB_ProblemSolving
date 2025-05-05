package problems;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PS_240519_중간평균값구하기_SWEA1984 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int sum = 0;
            for (int i = 1; i < 9; i++) {
                sum += arr[i];
            }
            int result = BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(8), RoundingMode.HALF_EVEN).intValue();
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}

