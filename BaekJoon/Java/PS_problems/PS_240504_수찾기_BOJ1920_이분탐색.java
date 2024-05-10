package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PS_240504_수찾기_BOJ1920_이분탐색 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] narr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] marr = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            marr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(narr);

        for (int i = 0; i < M; i++) {
            boolean isExist = myBinarySearch(marr[i], narr);
            sb.append(isExist ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean myBinarySearch(int target, int[] narr) {
        int start = 0;
        int end = narr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int curr = narr[mid];

            if (curr < target) {
                start = mid + 1;
            }

            else if (target < curr) {
                end = mid - 1;
            }

            else return true;
        }
        return false;
    }
}
