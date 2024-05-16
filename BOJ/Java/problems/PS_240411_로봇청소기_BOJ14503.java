package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PS_240411_로봇청소기_BOJ14503 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static class MapInfo {
        private final int n;
        private final int m;

        public MapInfo(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private static class RobotInfo {
        private final Point p;
        private final int d;

        public RobotInfo(Point p, int d) {
            this.p = p;
            this.d = d;
        }

        public Point getPoint() { return p; }

        public int getD() {
            return d;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve(map, new MapInfo(n,m), new RobotInfo(new Point(r,c),d)));

    }

    private static int solve(int[][] map, MapInfo mapInfo, RobotInfo robotInfo) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(robotInfo.getPoint());
        map[robotInfo.getPoint().getX()][robotInfo.getPoint().getY()] = -1;

        int d = robotInfo.getD();

        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};

        int cnt = 1;

        while (!queue.isEmpty()) {
            Point curr = queue.peek();
            queue.poll();
            int nx = curr.getX();
            int ny = curr.getY();

            if (map[nx][ny] != -1) {
                map[nx][ny] = -1;
                cnt++;
            }

            if (hasUnclean(map,nx,ny)) {
                if (d == 0) d = 3;
                else d = d-1;

                if (map[nx+dx[d]][ny+dy[d]] == 0) {
                    queue.add(new Point(nx+dx[d],ny+dy[d]));
                }
            }

            else {
                if (d < 2) d += 2;
                else d -= 2;

                if (map[nx+dx[d]][ny+dy[d]] != 1) {
                    queue.add(new Point(nx+dx[d],ny+dy[d]));
                }
            }
        }

        return cnt;

    }

    private static boolean hasUnclean(int[][] map, int nx, int ny) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for (int i = 0; i < 4; i++) {
            if (map[nx+dx[i]][ny+dy[i]] == 0) {
                return true;
            }
        }
        return false;
    }


}
