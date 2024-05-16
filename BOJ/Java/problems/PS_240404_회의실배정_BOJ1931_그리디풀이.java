package PS_problems;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PS_240404_회의실배정_BOJ1931_그리디풀이 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        ArrayList<Point> meets = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String meetInfo = br.readLine();
            int start = Integer.parseInt(meetInfo.split(" ")[0]);
            int end = Integer.parseInt(meetInfo.split(" ")[1]);
            meets.add(new Point(start,end));
        }

        meets = (ArrayList<Point>) meets.stream()
                .sorted(Comparator.comparing(Point::getY).thenComparing(Point::getX))
                .collect(Collectors.toList());

        int curr = meets.get(0).y;
        int cnt = 1;

        for (int i = 1; i < meets.size(); i++) {
            if (curr <= meets.get(i).x) {
                cnt += 1;
                curr = meets.get(i).y;
            }
        }

        System.out.println(cnt);
    }
}
