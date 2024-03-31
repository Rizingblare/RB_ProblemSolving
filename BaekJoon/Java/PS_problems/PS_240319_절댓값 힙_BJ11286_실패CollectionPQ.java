package PS_2024_03_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PS_BJ11286_CollectionPQ_240319 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(abs1, abs2);
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int item = Integer.parseInt(br.readLine());

            if (item != 0) {
                pq.offer(item);
            }

            else {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(pq.peek()).append("\n");
                    pq.poll();
                }
            }
        }
        System.out.println(sb);
    }

}
