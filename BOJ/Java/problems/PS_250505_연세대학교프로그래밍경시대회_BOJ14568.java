package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS_250505_연세대학교프로그래밍경시대회_BOJ14568 {

   /*
        1. 아이디어:
        - N개의 사탕을 A,B,C가 나눠갖는 서로 다른 경우의 수
        - A,B,C는 모두 1개 이상
        - 남은 사탕은 있을 수 없다
        - A가 B보다 2개 이상
        - C는 짝수개

        2. 시간 복잡도:
        (sol 1) 3번의 반복문 = O(N^3)
        - N^3 = 10^6  (가능)

        3. 자료구조:
        - 0 < N < 101 (int)

     */

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        long cnt = 0;
        for (int i = 0; i <= N; i++) {
            if (i < 1) continue;

            for (int j = 0; j <= N-i; j++) {
                if (j < 1) continue;
                if (j - i < 2) continue;

                for (int k = 0; k <= N-i-j; k++) {
                    if (k < 1) continue;
                    if (k % 2 != 0) continue;
                    if (i+j+k != N) continue;
                    //System.out.printf("i=%d j=%d k=%d\n", i,j,k);
                    cnt++;
                } // end k
            } // end j
        } // end i

        System.out.println(cnt);
    }
}
