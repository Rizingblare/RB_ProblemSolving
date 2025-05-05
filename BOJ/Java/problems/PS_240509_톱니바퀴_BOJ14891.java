package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PS_240509_톱니바퀴_BOJ14891 {
    /*
    1. 아이디어:

    4개의 톱니바퀴 = new int[4][8]
    N극은 0, S극은 1

    회전시킬 톱니 번호 num
    회전시킬 방향 시계방향 1
    회전시킬 방향 반시계방향 -1

    1번 톱니바퀴 12시 방향 N극 0점 S극 1점
    2번 톱니바퀴 12시 방향 N극 0점 S극 2점
    3번 톱니바퀴 12시 방향 N극 0점 S극 4점
    4번 톱니바퀴 12시 방향 N극 0점 S극 8점


    2. 시간 복잡도:

    3. 자료구조:


    */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotate(arr,num,dir);

        }

    }

    private static void rotate(int[][] arr, int num, int dir) {
        if (dir == 1) {
            int tmp = arr[num][7];
            for (int i = 0; i < 7; i++) {
                arr[i+1] = arr[i];
            }
            arr[num][0] = tmp;
        }
        else {
            int tmp = arr[num][0];
            for (int i = 1; i < 8; i++) {
                arr[i-1] = arr[i];
            }
            arr[num][7] = tmp;
        }
    }
}
