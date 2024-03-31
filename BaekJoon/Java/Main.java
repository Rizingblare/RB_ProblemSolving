package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean flag = false;
        for (int i = N-1; i > 0; i--) {
            int max = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            if (i == max) continue;
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] == target[j]) {
                    cnt++;
                }
            }
            if (cnt == N) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

}
