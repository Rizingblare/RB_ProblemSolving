package problems;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class PS_240402_단지번호붙이기_BOJ2667_BFS풀이 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(board,N);
        System.out.println(sb);
    }

    private static void bfs(int[][] board, int N) {

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};

        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue;
                if (!visit[i][j]) {
                    cnt++;
                    visit[i][j] = true;
                    queue.add(new Point(i,j));

                    int household = 0;
                    while (!queue.isEmpty()) {
                        Point curr = queue.peek();
                        household++;
                        queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = curr.x + dx[k];
                            int ny = curr.y + dy[k];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if (board[nx][ny] != 1 || visit[nx][ny]) continue;
                            visit[nx][ny] = true;
                            queue.add(new Point(nx,ny));
                        }
                    }
                    arr.add(household);
                }
            }
        }

        sb.append(cnt).append("\n");
        arr.sort(Comparator.naturalOrder());
        for (int i : arr) {
            sb.append(i).append("\n");
        }
    }
}
