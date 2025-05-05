import java.util.*;
import java.io.*;

class Solution
{
    private static int times;
    private static int[] num;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws Exception
    {
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = st.nextToken().chars().map(c -> c -'0').toArray();
            times = Integer.parseInt(st.nextToken());
            for (int i : num) {
                System.out.println(i);
            }

        }
    }
}