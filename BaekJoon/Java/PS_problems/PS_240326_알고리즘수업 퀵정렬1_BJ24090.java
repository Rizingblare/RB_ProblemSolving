package PS_2024_03_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS_BJ24090_20240326 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String nK = br.readLine();
        int n = Integer.parseInt(nK.split(" ")[0]);
        int K = Integer.parseInt(nK.split(" ")[1]);

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, n-1);

    }

    private static void quickSort(int[] arr, int i, int i1) {
    }

}
