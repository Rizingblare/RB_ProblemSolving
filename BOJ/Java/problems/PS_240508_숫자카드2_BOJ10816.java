package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    1. 아이디어:
    - 정렬 후 이분탐색으로 숫자를 찾은 후, 있으면 몇번 등장했는지 카운트
    2. 시간 복잡도:
    - O(NlogN) = 500000 * 10 < 2억
    3. 자료구조:
    - 숫자 카드 int
    - 숫자 카드 리스트 int[]
 */

public class PS_240508_숫자카드2_BOJ10816 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] narr = new int[N];
        for (int i = 0; i < N; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(narr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] marr = new int[M];
        for (int i = 0; i < M; i++) {
            marr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int cnt = upper_idx(narr, marr[i]) - lower_idx(narr, marr[i]);
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

    }

    private static int lower_idx(int[] arr, int target) {
        int st = 0;
        int en = arr.length;
        while (st < en) {
            int mid = (st + en) / 2;

            if (arr[mid] < target) {
                st = mid + 1;
            }
            else {
                en = mid;
            }
        }
        return st;
    }

    private static int upper_idx(int[] arr, int target) {
        int st = 0;
        int en = arr.length;

        while (st < en) {
            int mid = (st + en) / 2;

            if (target < arr[mid]) {
                en = mid;
            }

            else {
                st = mid + 1;
            }
        }

        return st;
    }
}
