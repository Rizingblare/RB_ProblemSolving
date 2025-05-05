package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PS_250505_암호키_BOJ1816 {

    /*
        1. 아이디어:
        - 입력받은 N개의 수가 각각 적절한 암호키에 해당하는지 출력하기
        - 입력받은 수의 모든 소인수가 10^6(백만)보다 크다면 적절한 암호키
        - 모든 소인수를 추출, 해당 소인수가 백만보다 작은지 판별하는 알고리즘

        2. 시간 복잡도:
        (sol 1) 해당 숫자를 1부터 100만까지 나눠보고 안나눠지면 true
        - 시간 복잡도 10^6 * N(10) => 10*7(천만) = 가능


        3. 자료구조:
        - 1 < n < 10 (int)
        - 10^12 < s < 10^18 (long)

     */

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Long[] arr = new Long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        String YES = "YES";
        String NO = "NO";

        // i는 최대 10
        for (int i = 0; i < N; i++) {
            Long s = arr[i];
            // 최대 1,000,000번 반복
            if (isBigPrimeNumber(s)) {
               System.out.println(YES);
            }
            else {
                System.out.println(NO);
            }
        }
    }

    private static boolean isBigPrimeNumber(long s) {
        final int STANDARD = 1000000;
        for (int i = 2; i <= STANDARD; i++) {
            if (s % i == 0) {
                return false;
            }
        }
        return true;
    }
}
