package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 1. 아이디어
 - 이중 for문, 값 1 && 방문 X => 재귀 DFS
 - DFS를 통해 찾은 값을 저장 후 정렬 후 출력
 2. 시간복잡도
 - DFS : O(V*E)
 - V, E : N^2, 4N^2
 - V+E : 5N^2 ~= N^2 ~= 625 >> 가능 (2억 under)

 3. 자료구조
 - 그래프 저장 : int[][]
 - 방문여부 : boolean[][]
 - 결과값 : int[]
*/

public class PS_240507_단지번호붙이기_BOJ2667_DFS {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static int[][] board;
    private static boolean[][] vis;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    private static int N;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        vis = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) == '1' ? 1 : 0;
            }
        }

        List<Integer> cntList = new ArrayList<>();
        int town = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vis[i][j] || board[i][j] == 0) continue;
                town++;
                cnt = 0;
                dfs(i,j);
                cntList.add(cnt);
            }
        }

        Collections.sort(cntList);
        sb.append(town).append("\n");

        for (int i : cntList) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int x, int y) {
        vis[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (vis[nx][ny] || board[nx][ny] != 1) continue;
            dfs(nx,ny);
        }
    }

}
