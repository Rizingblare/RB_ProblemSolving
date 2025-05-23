package problems;

import java.util.Scanner;

public class PS_240202_N과M2_BOJ15650_removeVisit {

    private static final Scanner sc = new Scanner(System.in);
    private static final StringBuilder sb = new StringBuilder();

    private static int n;
    private static int m;
    private static int[] arr;

    private static void backtrack(int at, int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= n; i++) {
            arr[depth] = i;
            backtrack(i+1, depth+1);
        }
    }


    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        backtrack(1,0);
        System.out.println(sb);
    }
}